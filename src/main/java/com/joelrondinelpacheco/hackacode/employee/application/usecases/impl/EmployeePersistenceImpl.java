package com.joelrondinelpacheco.hackacode.employee.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.person.application.dto.NewPersonDTO;
import com.joelrondinelpacheco.hackacode.security.application.usecases.JwtTokenService;
import com.joelrondinelpacheco.hackacode.security.application.utilities.AuthUtils;
import com.joelrondinelpacheco.hackacode.employee.application.dto.NewEmployeeDTO;
import com.joelrondinelpacheco.hackacode.employee.application.port.in.EmployeePersistence;
import com.joelrondinelpacheco.hackacode.employee.application.port.out.EmployeePersistencePort;
import com.joelrondinelpacheco.hackacode.employee.application.usecases.EmployeeUtils;
import com.joelrondinelpacheco.hackacode.person.application.port.in.PersonPersistence;
import com.joelrondinelpacheco.hackacode.person.application.port.in.PersonUtils;
import com.joelrondinelpacheco.hackacode.person.application.usecases.PersonBuilder;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
import com.joelrondinelpacheco.hackacode.employee.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

@UseCase
public class EmployeePersistenceImpl implements EmployeePersistence {

    @Autowired
    private EmployeePersistencePort employeePersistencePort;
    @Autowired
    private PersonPersistence userRepository;
    @Autowired
    private PersonPersistence personPersistence;

    @Autowired
    private PersonUtils personUtils;
    @Autowired
    private EmployeeUtils employeeUtils;
    @Autowired
    private PersonBuilder personBuilder;
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private AuthUtils authUtils;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Employee newEmployee(NewEmployeeDTO employeeDTO) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
        //CHECKEA QUE EL USUARIO EXISTA USUARIO NO EXISTE
        this.personUtils.assertDoesNotExistsByEmail(employeeDTO.getEmail());
        //NO EXISTE EMPLEADO RELACIONADO A ESE USUARIO
        this.employeeUtils.assertDoesNotExistsByUserEmail(employeeDTO.getEmail());

        //TODO CREATE BUILDER UTILS CLASS
        NewPersonDTO newPersonDTO = NewPersonDTO.builder()
                .name(employeeDTO.getName())
                .lastname(employeeDTO.getLastname())
                .email(employeeDTO.getName())
                .address(employeeDTO.getAddress())
                .dni(employeeDTO.getDni())
                .birthday(employeeDTO.getBirthday())
                .phoneNumber(employeeDTO.getPhoneNumber())
                .roleId(employeeDTO.getRoleId())
                .build();

        Person person = this.personPersistence.save(newPersonDTO);

        String randomPassword = this.employeeUtils.createRandomPassword();
        String finalPassword = this.passwordEncoder.encode(randomPassword);

        Employee employee = new Employee();
        employee.setSalary(employeeDTO.getSalary());
        employee.setPerson(person);
        employee.setPassword(finalPassword);

        Employee employeeSaved = this.employeePersistencePort.registerUser(employee);

/*
TODO IMPLEMENT
        Map<String, Object> extraClaims = this.generateExtraClaims(person);
        String jwt = this.jwtTokenService.generateToken(person.getEmail(), extraClaims);
        JwtToken jwtToken = JwtToken.builder()
                .token(jwt)
                .expiration(this.jwtTokenService.extractExpiration(jwt))
                .isValid(true)
                .employee(employeeSaved)
                .build();

        this.jwtTokenService.saveToken()
*/


        return employeeSaved;
    }

    private Map<String, Object> generateExtraClaims(Person person) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", person.getName());
        extraClaims.put("role", person.getRole().getName());
        extraClaims.put("authorities", this.authUtils.getAuthorities(person.getRole()));
        return extraClaims;
    }
}
