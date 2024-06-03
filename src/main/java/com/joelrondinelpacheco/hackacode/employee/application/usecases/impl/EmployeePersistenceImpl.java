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
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

@UseCase
public class EmployeePersistenceImpl implements EmployeePersistence {

    @Autowired
    private EmployeePersistencePort employeePersistencePort;
    @Autowired
    private EmployeeUtils employeeUtils;
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private AuthUtils authUtils;

    @Override
    public Employee createEmployee(Person person, BigDecimal salary) {
        this.employeeUtils.assertDoesNotExistsByUserEmail(person.getEmail());
        Employee employee = new Employee();
        employee.setSalary(salary);
        employee.setPerson(person);
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


        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return this.employeePersistencePort.registerUser(employee);
    }

    private Map<String, Object> generateExtraClaims(Person person) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", person.getName());
        //TODO IMPLEMENT
        //extraClaims.put("role", person.getRole().getName());
        //extraClaims.put("authorities", this.authUtils.getAuthorities(person.getRole()));
        return extraClaims;
    }
}
