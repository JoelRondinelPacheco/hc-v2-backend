package com.joelrondinelpacheco.hackacode.person.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.common.adapter.Mapper;
import com.joelrondinelpacheco.hackacode.person.application.port.out.PersonPersistencePort;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceAdapter
public class PersonPersistenceAdapter implements PersonPersistencePort {
    @Autowired
    private PersonMySQLRepository personMySQLRepository;
    @Autowired
    @Qualifier("personMapper")
    private Mapper<Person, PersonEntity> mapper;

    @Override
    public Person save(Person person) {
        PersonEntity personEntity = this.personMySQLRepository.save(this.mapper.domainToEntity(person));
        Person personSaved = this.mapper.entityToDomain(personEntity);
        personSaved.setId(personEntity.getId());
        return personSaved;
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
