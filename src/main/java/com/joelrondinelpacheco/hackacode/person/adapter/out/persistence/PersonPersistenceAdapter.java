package com.joelrondinelpacheco.hackacode.person.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.common.adapter.Mapper;
import com.joelrondinelpacheco.hackacode.common.domain.EntityAlreadyExistsException;
import com.joelrondinelpacheco.hackacode.common.domain.PersistenceException;
import com.joelrondinelpacheco.hackacode.person.application.port.out.PersonPersistencePort;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;

@PersistenceAdapter
public class PersonPersistenceAdapter implements PersonPersistencePort {
    @Autowired
    private PersonMySQLRepository personMySQLRepository;
    @Autowired
    @Qualifier("personMapper")
    private Mapper<Person, PersonEntity> mapper;

    @Override
    public Person save(Person person) {
        try {
            PersonEntity personEntity = this.personMySQLRepository.save(this.mapper.domainToEntity(person));
            Person personSaved = this.mapper.entityToDomain(personEntity);
            personSaved.setId(personEntity.getId());
            return personSaved;
        } catch (DuplicateKeyException e) {
            throw new EntityAlreadyExistsException("User email: " + person.getEmail() + ", already exists.");
        } catch (ConstraintViolationException | DataIntegrityViolationException e) {
            throw new PersistenceException((e.getMessage()));
        }
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
