package com.cleancoders.hackacode.person.application.port.in;

import com.cleancoders.hackacode.person.application.dto.NewPersonDTO;
import com.cleancoders.hackacode.person.domain.Person;

public interface PersonPersistence {
    Person save(NewPersonDTO person);
    Person update(Person person);
    String delete(Long userId);
}
