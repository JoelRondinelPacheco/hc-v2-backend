package com.cleancoders.hackacode.person.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.person.domain.Person;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceMapper
@Qualifier("personMapper")
public class PersonMapper implements Mapper<Person, PersonEntity> {

    @Override
    public Person entityToDomain(PersonEntity personEntity) {
        return  Person.builder()
                .name(personEntity.getName())
                .lastname(personEntity.getLastname())
                .email(personEntity.getEmail())
                .address(personEntity.getAddress())
                .dni(personEntity.getDni())
                .birthday(personEntity.getBirthday())
                .nationality(personEntity.getNationality())
                .phoneNumber(personEntity.getPhoneNumber())
                .build();
    }

    @Override
    public PersonEntity domainToEntity(Person person) {
        return   PersonEntity.builder()
                .name(person.getName())
                .lastname(person.getLastname())
                .email(person.getEmail())
                .address(person.getAddress())
                .dni(person.getDni())
                .birthday(person.getBirthday())
                .nationality(person.getNationality())
                .phoneNumber(person.getPhoneNumber())
                .build();
    }
}
