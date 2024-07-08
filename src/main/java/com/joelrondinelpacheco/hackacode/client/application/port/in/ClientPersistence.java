package com.joelrondinelpacheco.hackacode.client.application.port.in;

import com.joelrondinelpacheco.hackacode.person.application.dto.EditClientDTO;
import com.joelrondinelpacheco.hackacode.person.application.dto.NewPersonDTO;
import com.joelrondinelpacheco.hackacode.client.domain.Client;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
import com.joelrondinelpacheco.hackacode.users.application.dto.UserStarterDTO;

public interface ClientPersistence {
    Client createClient(Person user);
    Client saveClient(UserStarterDTO info);
    Client update(EditClientDTO dto);
    String delete(Long id);
}
