package com.cleancoders.hackacode.person.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.person.domain.Person;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceMapper
@Qualifier("personMapper")
public class PersonMapper implements Mapper<Person, PersonEntity> {

    @Override
    public Person entityToDomain(PersonEntity entity) {
        return  Person.builder()
                .name(entity.getName())
                .lastname(entity.getLastname())
                .email(entity.getEmail())
                .address(entity.getAddress())
                .dni(entity.getDni())
                .birthday(entity.getBirthday())
                .nationality(entity.getNationality())
                .phoneNumber(entity.getPhoneNumber())
                .build();
    }

    @Override
    public PersonEntity domainToEntity(Person domain) {
        return   PersonEntity.builder()
                .name(domain.getName())
                .lastname(domain.getLastname())
                .email(domain.getEmail())
                .address(domain.getAddress())
                .dni(domain.getDni())
                .birthday(domain.getBirthday())
                .nationality(domain.getNationality())
                .phoneNumber(domain.getPhoneNumber())
                .build();
    }
}
