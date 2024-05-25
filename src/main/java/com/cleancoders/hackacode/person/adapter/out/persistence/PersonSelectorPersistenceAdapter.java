package com.cleancoders.hackacode.person.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.person.application.port.out.PersonSelectorPort;
import com.cleancoders.hackacode.person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@PersistenceAdapter
public class PersonSelectorPersistenceAdapter implements PersonSelectorPort {

    @Autowired
    private PersonMySQLRepository personMySQLRepository;
    @Autowired
    @Qualifier("personMapper")
    private Mapper<Person, PersonEntity> mapper;

    @Override
    public Page<Person> getAll(Pageable pageable) {
        return this.personMySQLRepository.findAll(pageable).map(this.mapper::entityToDomain);
    }
}
