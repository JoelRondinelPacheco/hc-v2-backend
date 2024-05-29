package com.joelrondinelpacheco.hackacode.client.application.port.in;

import com.joelrondinelpacheco.hackacode.person.application.dto.NewPersonDTO;
import com.joelrondinelpacheco.hackacode.client.domain.Client;

public interface ClientPersistence {
    Client newClient(NewPersonDTO user);
    Client update();
    String delete(Long id);
}
