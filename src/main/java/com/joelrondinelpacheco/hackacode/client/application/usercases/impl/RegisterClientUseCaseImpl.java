package com.joelrondinelpacheco.hackacode.client.application.usercases.impl;

import com.joelrondinelpacheco.hackacode.client.application.port.in.ClientPersistence;
import com.joelrondinelpacheco.hackacode.client.domain.Client;
import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.person.application.dto.NewPersonDTO;
import com.joelrondinelpacheco.hackacode.person.application.port.in.PersonPersistence;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
import com.joelrondinelpacheco.hackacode.client.application.port.in.RegisterClientUseCase;
import com.joelrondinelpacheco.hackacode.security.application.port.in.RoleSelector;
import com.joelrondinelpacheco.hackacode.security.application.port.in.UserCredentialsService;
import com.joelrondinelpacheco.hackacode.security.domain.Role;
import com.joelrondinelpacheco.hackacode.security.domain.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class RegisterClientUseCaseImpl implements RegisterClientUseCase {

    @Value("${security.default.role}")
    private String DEFAULT_ROLE;

    private final PersonPersistence personPersistence;
    private final RoleSelector roleSelector;
    private final UserCredentialsService userCredentialsService;
    private final ClientPersistence clientPersistence;

    @Autowired
    public RegisterClientUseCaseImpl(PersonPersistence personPersistence, RoleSelector roleSelector, UserCredentialsService userCredentialsService, ClientPersistence clientPersistence) {
        this.personPersistence = personPersistence;
        this.roleSelector = roleSelector;
        this.userCredentialsService = userCredentialsService;
        this.clientPersistence = clientPersistence;
    }


    @Override
    @Transactional
    public void createClient(NewPersonDTO body) {
        //TODO CHEKEAR EMAIL ANTES DE CREAR? (ya lo hace en las clases)
        Person person = this.personPersistence.create(body);
        Role role = this.roleSelector.getByRoleName(DEFAULT_ROLE);
        Client client = this.clientPersistence.createClient(person);

        UserCredentials userCredentials = this.userCredentialsService.newUserCredentials(person, role, body.getPassword());
        person.setUserCredentials(userCredentials);

        this.personPersistence.save(person);
        this.clientPersistence.saveClient(client);
        this.userCredentialsService.saveUserCredentials(userCredentials);
    }
}
