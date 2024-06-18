package com.joelrondinelpacheco.hackacode.security.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
import com.joelrondinelpacheco.hackacode.security.application.port.in.UserCredentialsService;
import com.joelrondinelpacheco.hackacode.security.application.port.out.UserCredentialsPersistencePort;
import com.joelrondinelpacheco.hackacode.security.application.usecases.JwtTokenService;
import com.joelrondinelpacheco.hackacode.security.domain.Role;
import com.joelrondinelpacheco.hackacode.security.domain.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

@UseCase
public class UserCredentialsServiceImpl implements UserCredentialsService {

    private final PasswordEncoder passwordEncoder;
    private final UserCredentialsPersistencePort userCredentialsPersistencePort;
    private final JwtTokenService jwtTokenService;

    @Autowired
    public UserCredentialsServiceImpl(PasswordEncoder passwordEncoder, UserCredentialsPersistencePort userCredentialsPersistencePort, JwtTokenService jwtTokenService) {
        this.passwordEncoder = passwordEncoder;
        this.userCredentialsPersistencePort = userCredentialsPersistencePort;
        this.jwtTokenService = jwtTokenService;
    }

    @Override
    public UserCredentials newUserCredentials(Person person, Role role, String password) {
        //TODO RANDOM PASSWORD EN EMPLOYEE UTILS
        String emailToken = this.jwtTokenService.generateVerifyEmailToken(person.getEmail());

        UserCredentials userCredentials = UserCredentials.builder()
                .person(person)
                .password(this.encryptPassword(password))
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(false)
                .emailToken(emailToken)
                .build();
        return userCredentials;
    }

    @Override
    public UserCredentials saveUserCredentials(UserCredentials userCredentials) {
        return this.userCredentialsPersistencePort.save(userCredentials);
    }

    @Override
    public void enableAccountByEmailConfirmation() {

    }

    @Override
    public void disableAccount() {

    }

    @Override
    public void verifyCredentialsNonExpired(UserCredentials credentials) {
        if (!credentials.isCredentialsNonExpired()) {
            throw new RuntimeException("todo invalid credentials");
        }

        if (this.jwtTokenService.isExpired(credentials.getEmailToken())) {
            credentials.setCredentialsNonExpired(false);
            this.userCredentialsPersistencePort.save(credentials);
            throw new RuntimeException("todo invalid credentials");
        }
    }

    @Override
    public void verifyAccountNonLocked(UserCredentials userCredentials) {
        if (!userCredentials.isAccountNonLocked()) {
            throw new RuntimeException("todo invalid credentials");
        }
    }

    private String encryptPassword(String password) {
        return this.passwordEncoder.encode(password);
    }
}
