package com.cleancoders.hackacode.client.application.port.in;

import com.cleancoders.hackacode.client.application.dto.NewUserDTO;
import com.cleancoders.hackacode.client.domain.Client;

public interface ClientPersistence {
    Client save(NewUserDTO user);
    Client update();
    String delete();
}
