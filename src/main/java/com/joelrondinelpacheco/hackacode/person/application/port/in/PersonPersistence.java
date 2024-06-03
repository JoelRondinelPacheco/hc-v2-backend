package com.joelrondinelpacheco.hackacode.person.application.port.in;

import com.joelrondinelpacheco.hackacode.person.application.dto.NewPersonDTO;
import com.joelrondinelpacheco.hackacode.person.domain.Person;

public interface PersonPersistence {

    Person create(NewPersonDTO personDTO);
    Person save(Person person);
    Person update(Person person);
    String delete(Long userId);
}
