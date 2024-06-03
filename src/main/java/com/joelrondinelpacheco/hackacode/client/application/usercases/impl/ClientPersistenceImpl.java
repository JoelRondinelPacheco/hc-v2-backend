package com.joelrondinelpacheco.hackacode.client.application.usercases.impl;

import com.joelrondinelpacheco.hackacode.client.application.port.in.ClientPersistence;
import com.joelrondinelpacheco.hackacode.client.application.port.in.ClientUtils;
import com.joelrondinelpacheco.hackacode.client.application.port.out.ClientPersistencePort;
import com.joelrondinelpacheco.hackacode.client.domain.Client;
import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.person.application.usecases.PersonBuilder;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class ClientPersistenceImpl implements ClientPersistence {

    @Autowired
    private ClientPersistencePort clientRepository;
    @Autowired
    private ClientUtils clientUtils;
    @Autowired
    private PersonBuilder personBuilder;

    @Override
    public Client createClient(Person person) {

        Client client = new Client();
        client.setPerson(person);

        return client;
    }

    @Override
    public Client saveClient(Client client) {
        this.clientUtils.assertDoesNotExistsByUserEmail(client.getPerson().getEmail());
        return this.clientRepository.save(client);
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
