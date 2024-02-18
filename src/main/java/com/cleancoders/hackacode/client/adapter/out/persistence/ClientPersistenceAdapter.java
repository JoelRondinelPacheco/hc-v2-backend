package com.cleancoders.hackacode.client.adapter.out.persistence;

import com.cleancoders.hackacode.client.application.port.out.ClientPersistencePort;
import com.cleancoders.hackacode.client.domain.Client;
import com.cleancoders.hackacode.common.PersistenceAdapter;

@PersistenceAdapter
public class ClientPersistenceAdapter implements ClientPersistencePort {
    @Override
    public Client save(Client client) {
        return null;
    }

    @Override
    public Client update() {
        return null;
    }

    @Override
    public String delete() {
        return null;
    }
}
