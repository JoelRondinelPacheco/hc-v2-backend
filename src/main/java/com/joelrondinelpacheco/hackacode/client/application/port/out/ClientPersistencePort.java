package com.joelrondinelpacheco.hackacode.client.application.port.out;

import com.joelrondinelpacheco.hackacode.client.domain.Client;

public interface ClientPersistencePort {
    Client save(Client client);
    Client update();
    String delete();
}
