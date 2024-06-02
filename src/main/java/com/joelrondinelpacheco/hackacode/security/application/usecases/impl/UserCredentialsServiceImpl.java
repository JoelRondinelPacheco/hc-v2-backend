package com.joelrondinelpacheco.hackacode.security.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
import com.joelrondinelpacheco.hackacode.security.application.port.in.UserCredentialsService;
import com.joelrondinelpacheco.hackacode.security.application.port.out.UserCredentialsPersistencePort;
import com.joelrondinelpacheco.hackacode.security.domain.Role;
import com.joelrondinelpacheco.hackacode.security.domain.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@UseCase
public class UserCredentialsServiceImpl implements UserCredentialsService {

    private final PasswordEncoder passwordEncoder;
    private final UserCredentialsPersistencePort userCredentialsPersistencePort;

    @Autowired
    public UserCredentialsServiceImpl(PasswordEncoder passwordEncoder, UserCredentialsPersistencePort userCredentialsPersistencePort) {
        this.passwordEncoder = passwordEncoder;
        this.userCredentialsPersistencePort = userCredentialsPersistencePort;
    }

    @Override
    public UserCredentials newUserCredentials(Person person, Role role, String password) {
        UserCredentials userCredentials = UserCredentials.builder()
                .person(person)
                .password(this.encryptPassword(password))
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(false)
                .token("todo set token")
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

    private String encryptPassword(String password) {
        return this.passwordEncoder.encode(password);
    }
}
