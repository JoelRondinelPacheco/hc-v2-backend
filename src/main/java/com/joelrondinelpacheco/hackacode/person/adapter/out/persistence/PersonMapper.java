package com.joelrondinelpacheco.hackacode.person.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceMapper;
import com.joelrondinelpacheco.hackacode.common.adapter.Mapper;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
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
                .phoneNumber(domain.getPhoneNumber())
                .build();
    }
}
