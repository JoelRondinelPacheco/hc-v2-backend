package com.cleancoders.hackacode.person.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.person.application.port.in.PersonPersistence;
import com.cleancoders.hackacode.person.application.port.out.PersonPersistencePort;
import com.cleancoders.hackacode.person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class PersonPersistenceImpl implements PersonPersistence {

    @Autowired
    private PersonPersistencePort userRepository;

    @Override
    public Person save(Person person) {
        return this.userRepository.save(person);
    }

    @Override
    public Person update(Person person) {
        return null;
    }

    @Override
    public String delete(Long userId) {
        return null;
    }
}
