package com.cleancoders.hackacode.client.adapter.out.persistence;

import com.cleancoders.hackacode.client.domain.Client;
import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.person.adapter.out.persistence.PersonEntity;
import com.cleancoders.hackacode.person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceMapper
@Qualifier("clientMapper")
public class ClientMapper implements Mapper<Client, ClientEntity> {

    @Autowired
    @Qualifier("personMapper")
    private Mapper<Person, PersonEntity> personMapper;


    @Override
    public Client entityToDomain(ClientEntity clientEntity) {
        Person person = this.personMapper.entityToDomain(clientEntity.getPerson());
        person.setId(clientEntity.getPerson().getId());
        Client client = Client.withUser(person);
        client.setId(clientEntity.getId());
        return client;
    }

    @Override
    public ClientEntity domainToEntity(Client client) {
        PersonEntity personEntity = this.personMapper.domainToEntity(client.getUser());
        personEntity.setId(client.getUser().getId());
        return ClientEntity.builder()
                .person(personEntity)
                .build();
    }
}
