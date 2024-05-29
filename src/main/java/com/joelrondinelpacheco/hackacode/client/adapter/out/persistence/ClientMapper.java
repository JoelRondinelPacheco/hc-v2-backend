package com.joelrondinelpacheco.hackacode.client.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.client.domain.Client;
import com.joelrondinelpacheco.hackacode.common.PersistenceMapper;
import com.joelrondinelpacheco.hackacode.common.adapter.Mapper;
import com.joelrondinelpacheco.hackacode.person.adapter.out.persistence.PersonEntity;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceMapper
@Qualifier("clientMapper")
public class ClientMapper implements Mapper<Client, ClientEntity> {

    @Autowired
    @Qualifier("personMapper")
    private Mapper<Person, PersonEntity> personMapper;


    @Override
    public Client entityToDomain(ClientEntity entity) {
        Person person = this.personMapper.entityToDomain(entity.getPerson());
        person.setId(entity.getPerson().getId());
        Client client = new Client();
        client.setPerson(person);
        client.setId(entity.getId());
        return client;
    }

    @Override
    public ClientEntity domainToEntity(Client domain) {
        PersonEntity personEntity = this.personMapper.domainToEntity(domain.getPerson());
        personEntity.setId(domain.getPerson().getId());
        return ClientEntity.builder()
                .person(personEntity)
                .build();
    }
}
