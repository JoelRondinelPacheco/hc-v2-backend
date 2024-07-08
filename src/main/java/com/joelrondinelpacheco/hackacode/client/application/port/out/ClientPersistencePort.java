package com.joelrondinelpacheco.hackacode.client.application.port.out;

import com.joelrondinelpacheco.hackacode.client.domain.Client;
import com.joelrondinelpacheco.hackacode.users.application.dto.UserStarterDTO;

public interface ClientPersistencePort {
    Client create(UserStarterDTO userInfo);
    Client save(Client client);
    String delete();
}
