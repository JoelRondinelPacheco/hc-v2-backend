package com.joelrondinelpacheco.hackacode.client.application.port.in;

import com.joelrondinelpacheco.hackacode.person.application.dto.NewPersonDTO;
import com.joelrondinelpacheco.hackacode.client.domain.Client;
import com.joelrondinelpacheco.hackacode.person.domain.Person;

public interface ClientPersistence {
    Client createClient(Person user);
    Client saveClient(Client client);
    Client update();
    String delete(Long id);
}
