package com.joelrondinelpacheco.hackacode.users.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.client.application.port.in.ClientPersistence;
import com.joelrondinelpacheco.hackacode.client.domain.Client;
import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.person.application.dto.NewPersonDTO;
import com.joelrondinelpacheco.hackacode.person.application.port.in.PersonPersistence;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
import com.joelrondinelpacheco.hackacode.users.application.dto.UserStarterDTO;
import com.joelrondinelpacheco.hackacode.users.application.usecases.UserStarterUseCase;
import com.joelrondinelpacheco.hackacode.security.application.port.in.RoleSelector;
import com.joelrondinelpacheco.hackacode.security.application.port.in.UserCredentialsService;
import com.joelrondinelpacheco.hackacode.security.domain.Role;
import com.joelrondinelpacheco.hackacode.security.domain.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class UserStarterUseCaseImpl implements UserStarterUseCase {

    private final PersonPersistence personPersistence;
    private final RoleSelector roleSelector;
    private final UserCredentialsService userCredentialsService;

    @Autowired
    public UserStarterUseCaseImpl(PersonPersistence personPersistence, RoleSelector roleSelector, UserCredentialsService userCredentialsService) {
        this.personPersistence = personPersistence;
        this.roleSelector = roleSelector;
        this.userCredentialsService = userCredentialsService;
    }


    @Override
    public UserStarterDTO createUserStarter(NewPersonDTO body) {

        Role role = this.roleSelector.getById(body.getRoleId());

        Person personSaved = this.personPersistence.save(
                this.personPersistence.create(body)
        );

        UserCredentials userCredentials = this.userCredentialsService.saveUserCredentials(
                this.userCredentialsService.newUserCredentials(personSaved, role, body.getPassword())
        );

        return UserStarterDTO.builder()
                .person(personSaved)
                .token(userCredentials.getEmailToken())
                .build();
    }
}
