package com.cleancoders.hackacode.client.application.port.in;

import com.cleancoders.hackacode.user.application.dto.NewUserDTO;
import com.cleancoders.hackacode.client.domain.Client;

public interface ClientPersistence {
    Client newClient(NewUserDTO user);
    Client update();
    String delete();
}
