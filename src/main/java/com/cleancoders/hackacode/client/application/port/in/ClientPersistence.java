package com.cleancoders.hackacode.client.application.port.in;

import com.cleancoders.hackacode.person.application.dto.NewPersonDTO;
import com.cleancoders.hackacode.client.domain.Client;

public interface ClientPersistence {
    Client newClient(NewPersonDTO user);
    Client update();
    String delete();
}
