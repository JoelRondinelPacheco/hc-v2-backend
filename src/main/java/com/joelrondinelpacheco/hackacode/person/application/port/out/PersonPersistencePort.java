package com.joelrondinelpacheco.hackacode.person.application.port.out;

import com.joelrondinelpacheco.hackacode.person.domain.Person;

public interface PersonPersistencePort {
    Person save(Person person);
    Person update(Person person);
    String delete(Long userId);
}
