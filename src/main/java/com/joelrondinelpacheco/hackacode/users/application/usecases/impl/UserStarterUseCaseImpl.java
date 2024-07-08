package com.joelrondinelpacheco.hackacode.users.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.employee.application.dto.NewEmployeeDTO;
import com.joelrondinelpacheco.hackacode.person.application.dto.NewClientDTO;
import com.joelrondinelpacheco.hackacode.person.application.dto.PersonBaseDTO;
import com.joelrondinelpacheco.hackacode.person.application.port.in.PersonPersistence;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
import com.joelrondinelpacheco.hackacode.security.domain.UserCredentialsReference;
import com.joelrondinelpacheco.hackacode.users.application.dto.UserStarterDTO;
import com.joelrondinelpacheco.hackacode.users.application.usecases.UserStarterUseCase;
import com.joelrondinelpacheco.hackacode.security.application.port.in.UserCredentialsService;
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
    public UserStarterDTO createPersonStarterFromAdmin(PersonBaseDTO person, Long roleId) {
        Person personEntity = this.personPersistence.createStarterPersonEntity(person);
        UserCredentialsReference userCredentials = this.userCredentialsService.newUserCredentialsReference(personEntity, roleId, this.getDefaultPassword());
        return UserStarterDTO.builder()
                .person(personEntity)
                .userCredentials(userCredentials)
                .build();
    }
    private String getDefaultPassword() {
        return "password1234";
    }
}
