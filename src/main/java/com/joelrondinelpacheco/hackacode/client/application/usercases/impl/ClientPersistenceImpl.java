package com.joelrondinelpacheco.hackacode.client.application.usercases.impl;

import com.joelrondinelpacheco.hackacode.client.application.port.in.ClientPersistence;
import com.joelrondinelpacheco.hackacode.client.application.port.in.ClientUtils;
import com.joelrondinelpacheco.hackacode.client.application.port.out.ClientPersistencePort;
import com.joelrondinelpacheco.hackacode.client.application.port.out.ClientSelectorPort;
import com.joelrondinelpacheco.hackacode.client.domain.Client;
import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.person.application.dto.EditClientDTO;
import com.joelrondinelpacheco.hackacode.person.application.port.out.PersonPersistencePort;
import com.joelrondinelpacheco.hackacode.person.application.port.out.PersonSelectorPort;
import com.joelrondinelpacheco.hackacode.person.application.usecases.PersonBuilder;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
import com.joelrondinelpacheco.hackacode.users.application.dto.UserStarterDTO;

import java.util.Objects;

@UseCase
public class ClientPersistenceImpl implements ClientPersistence {

    private final ClientPersistencePort clientRepository;
    private final ClientSelectorPort clientSelectorPort;
    private final ClientUtils clientUtils;
    private final PersonBuilder personBuilder;
    private final PersonSelectorPort personRepository;
    private final PersonPersistencePort personPersistencePort;

    public ClientPersistenceImpl(ClientPersistencePort clientRepository, ClientSelectorPort clientSelectorPort, ClientUtils clientUtils, PersonBuilder personBuilder, PersonSelectorPort personRepository, PersonPersistencePort personPersistencePort) {
        this.clientRepository = clientRepository;
        this.clientSelectorPort = clientSelectorPort;
        this.clientUtils = clientUtils;
        this.personBuilder = personBuilder;
        this.personRepository = personRepository;
        this.personPersistencePort = personPersistencePort;
    }

    @Override
    public Client createClient(Person person) {

        Client client = new Client();
        client.setPerson(person);

        return client;
    }

    @Override
    public Client saveClient(UserStarterDTO userInfo) {
        return this.clientRepository.create(userInfo);

    }

    @Override
    public Client update(EditClientDTO dto) {
        //TODO client exists with id
        Client client = this.clientSelectorPort.byId(dto.getId());

        if (!Objects.equals(client.getPerson().getId(), dto.getPersonId())) {
            throw new RuntimeException(("Todo handle ex"));
        }

        Person person = client.getPerson();
        person.setName(dto.getName());
        person.setLastname(dto.getLastname());
        person.setDni(dto.getDni());
        person.setBirthday(dto.getBirthday());
        client.setPerson(person);

        person = this.personPersistencePort.save(person);
        client.setPerson(person);
        return client;
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
