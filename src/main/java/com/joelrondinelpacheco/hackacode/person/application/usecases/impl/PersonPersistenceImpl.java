package com.joelrondinelpacheco.hackacode.person.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.employee.application.dto.NewEmployeeDTO;
import com.joelrondinelpacheco.hackacode.person.application.dto.NewClientDTO;
import com.joelrondinelpacheco.hackacode.person.application.dto.PersonBaseDTO;
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
    public Person create(NewClientDTO person) {
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
    public Person createStarterPersonEntity(PersonBaseDTO person) {
        return Person.builder()
                .name(person.getName())
                .lastname(person.getLastname())
                .email(person.getEmail())
                .address(person.getAddress())
                .dni(person.getDni())
                .birthday(person.getBirthday())
                .phoneNumber(person.getPhoneNumber())
                .build();
    }

    @Override
    public Person personForNewEmployeeFromAdmin(NewEmployeeDTO dto) {
        return Person.builder()
                .name(dto.getName())
                .lastname(dto.getLastname())
                .email(dto.getEmail())
                .birthday(dto.getBirthday())
                .dni(dto.getDni())
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
