package com.cleancoders.hackacode.person.application.port.in;

import com.cleancoders.hackacode.person.domain.Person;

public interface PersonPersistence {
    Person save(Person person);
    Person update(Person person);
    String delete(Long userId);
}
