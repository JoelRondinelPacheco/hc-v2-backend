package com.cleancoders.hackacode.user.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.mail.application.dto.Mail;
import com.cleancoders.hackacode.mail.application.port.in.MailService;
import com.cleancoders.hackacode.person.application.dto.NewPersonDTO;
import com.cleancoders.hackacode.security.application.usecases.CustomUsersDetailsUseCase;
import com.cleancoders.hackacode.security.application.usecases.JwtTokenService;
import com.cleancoders.hackacode.security.domain.JwtToken;
import com.cleancoders.hackacode.user.application.dto.NewEmployeeDTO;
import com.cleancoders.hackacode.user.application.port.in.UserPersistence;
import com.cleancoders.hackacode.user.application.port.out.UserPersistencePort;
import com.cleancoders.hackacode.user.application.usecases.EmployeeUtils;
import com.cleancoders.hackacode.user.domain.User;
import com.cleancoders.hackacode.person.application.port.in.PersonPersistence;
import com.cleancoders.hackacode.person.application.port.in.PersonUtils;
import com.cleancoders.hackacode.person.application.usecases.PersonBuilder;
import com.cleancoders.hackacode.person.domain.Person;
import com.cleancoders.hackacode.user.domain.UserBase;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

@UseCase
public class UserPersistenceImpl implements UserPersistence {

    @Autowired
    private UserPersistencePort userPersistencePort;
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
    private CustomUsersDetailsUseCase customUsersDetailsUseCase;

    @Autowired
    private MailService mailService;

    @Override
    public UserBase newEmployee(NewEmployeeDTO employeeDTO) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
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

        String password = this.employeeUtils.createRandomPassword();

        User user = new User();
        user.setSalary(employeeDTO.getSalary());
        user.setPerson(person);
        user.setPassword(password);

        UserBase userSaved = this.userPersistencePort.registerUser(user);

/*
TODO IMPLEMENT
        Map<String, Object> extraClaims = this.generateExtraClaims(person);
        String jwt = this.jwtTokenService.generateToken(person.getEmail(), extraClaims);
        JwtToken jwtToken = JwtToken.builder()
                .token(jwt)
                .expiration(this.jwtTokenService.extractExpiration(jwt))
                .isValid(true)
                .user(userSaved)
                .build();

        this.jwtTokenService.saveToken()
*/
        Mail mail = Mail.builder()
                .to(userSaved.getPerson().getEmail())
                .subject("user account")
                .message("todo implement message")
                .build();

        this.mailService.send(mail);

        return userSaved;
    }

    private Map<String, Object> generateExtraClaims(Person person) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", person.getName());
        extraClaims.put("role", person.getRole().getName());
        extraClaims.put("authorities", this.customUsersDetailsUseCase.getAuthorities(person.getRole()));
        return extraClaims;
    }
}
