package com.joelrondinelpacheco.hackacode.person.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.person.application.dto.NewPersonDTO;
import com.joelrondinelpacheco.hackacode.person.application.port.in.PersonPersistence;
import com.joelrondinelpacheco.hackacode.person.application.port.out.PersonPersistencePort;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
import com.joelrondinelpacheco.hackacode.security.application.port.out.RolePersistencePort;
import com.joelrondinelpacheco.hackacode.security.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class PersonPersistenceImpl implements PersonPersistence {

    @Autowired
    private PersonPersistencePort userRepository;
    @Autowired
    private RolePersistencePort rolePersistencePort;

    @Override
    public Person save(NewPersonDTO person) {
        Person p = Person.builder()
                .name(person.getName())
                .lastname(person.getLastname())
                .email(person.getEmail())
                .address(person.getAddress())
                .dni(person.getDni())
                .birthday(person.getBirthday())
                .phoneNumber(person.getPhoneNumber())
                .build();

        //TODO CHECK IF ROLE EXISTS
        Role r = this.rolePersistencePort.findById(person.getRoleId());
        p.setRole(r);
        return this.userRepository.save(p);
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
