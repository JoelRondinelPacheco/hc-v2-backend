package com.joelrondinelpacheco.hackacode.client.application.usercases.impl;

import com.joelrondinelpacheco.hackacode.client.application.port.in.ClientPersistence;
import com.joelrondinelpacheco.hackacode.client.application.port.in.ClientUtils;
import com.joelrondinelpacheco.hackacode.client.application.port.out.ClientPersistencePort;
import com.joelrondinelpacheco.hackacode.client.domain.Client;
import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.person.application.usecases.PersonBuilder;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
import com.joelrondinelpacheco.hackacode.users.application.dto.UserStarterDTO;

@UseCase
public class ClientPersistenceImpl implements ClientPersistence {

    private final ClientPersistencePort clientRepository;
    private final ClientUtils clientUtils;
    private final PersonBuilder personBuilder;

    public ClientPersistenceImpl(ClientPersistencePort clientRepository, ClientUtils clientUtils, PersonBuilder personBuilder) {
        this.clientRepository = clientRepository;
        this.clientUtils = clientUtils;
        this.personBuilder = personBuilder;
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
    public Client update() {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
