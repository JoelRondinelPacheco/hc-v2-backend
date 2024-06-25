package com.joelrondinelpacheco.hackacode.users.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.person.application.dto.NewPersonDTO;
import com.joelrondinelpacheco.hackacode.person.application.port.in.PersonPersistence;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
import com.joelrondinelpacheco.hackacode.security.domain.UserCredentialsReference;
import com.joelrondinelpacheco.hackacode.users.application.dto.UserStarterDTO;
import com.joelrondinelpacheco.hackacode.users.application.usecases.UserStarterUseCase;
import com.joelrondinelpacheco.hackacode.security.application.port.in.RoleSelector;
import com.joelrondinelpacheco.hackacode.security.application.port.in.UserCredentialsService;
import com.joelrondinelpacheco.hackacode.security.domain.Role;
import com.joelrondinelpacheco.hackacode.security.domain.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class UserStarterUseCaseImpl implements UserStarterUseCase {

    private final PersonPersistence personPersistence;
    private final UserCredentialsService userCredentialsService;

    @Autowired
    public UserStarterUseCaseImpl(PersonPersistence personPersistence, UserCredentialsService userCredentialsService) {
        this.personPersistence = personPersistence;
        this.userCredentialsService = userCredentialsService;
    }


    @Override
    public UserStarterDTO createUserStarter(NewPersonDTO body) {
        Person person = this.personPersistence.create(body);

        UserCredentialsReference userCredentials = this.userCredentialsService.newUserCredentialsReference(person, body.getRoleId(), body.getPassword());

        return UserStarterDTO.builder()
                .person(person)
                .userCredentials(userCredentials)
                .build();
    }
}
