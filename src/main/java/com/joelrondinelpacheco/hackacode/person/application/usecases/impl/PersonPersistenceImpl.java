package com.joelrondinelpacheco.hackacode.person.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.person.application.dto.NewPersonDTO;
import com.joelrondinelpacheco.hackacode.person.application.port.in.PersonPersistence;
import com.joelrondinelpacheco.hackacode.person.application.port.in.PersonUtils;
import com.joelrondinelpacheco.hackacode.person.application.port.out.PersonPersistencePort;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class PersonPersistenceImpl implements PersonPersistence {


    private final PersonPersistencePort personPersistencePort;
    private final PersonUtils personUtils;
    @Autowired
    public PersonPersistenceImpl(PersonPersistencePort personPersistencePort, PersonUtils personUtils) {
        this.personPersistencePort = personPersistencePort;
        this.personUtils = personUtils;
    }

    @Override
    public Person create(NewPersonDTO person) {
        Person p = Person.builder()
                .name(person.getName())
                .lastname(person.getLastname())
                .email(person.getEmail())
                .address(person.getAddress())
                .dni(person.getDni())
                .birthday(person.getBirthday())
                .phoneNumber(person.getPhoneNumber())
                .build();
        return p;
    }

    @Override
    public Person createLogin(NewPersonDTO person) {
        return Person.builder()
                .name(person.getName())
                .lastname(person.getLastname())
                .email(person.getEmail())
                .birthday(person.getBirthday())
                .build();
    }

    @Override
    public Person save(Person person) {
        this.personUtils.assertDoesNotExistsByEmail(person.getEmail());
        return this.personPersistencePort.save(person);
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
