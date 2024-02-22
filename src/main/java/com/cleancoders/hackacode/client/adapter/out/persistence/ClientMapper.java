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
    @Qualifier("userMapper")
    private Mapper<Person, PersonEntity> userMapper;


    @Override
    public Client entityToDomain(ClientEntity clientEntity) {
        Person person = this.userMapper.entityToDomain(clientEntity.getUser());
        person.setId(clientEntity.getUser().getId());
        Client client = Client.withUser(person);
        client.setId(clientEntity.getId());
        return client;
    }

    @Override
    public ClientEntity domainToEntity(Client client) {
        PersonEntity personEntity = this.userMapper.domainToEntity(client.getUser());
        personEntity.setId(client.getUser().getId());
        return ClientEntity.builder()
                .user(personEntity)
                .build();
    }
}
