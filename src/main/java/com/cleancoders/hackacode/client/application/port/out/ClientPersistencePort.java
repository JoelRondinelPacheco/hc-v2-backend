package com.cleancoders.hackacode.client.application.port.out;

import com.cleancoders.hackacode.client.domain.Client;

public interface ClientPersistencePort {
    Client save(Client client);
    Client update();
    String delete();
}
