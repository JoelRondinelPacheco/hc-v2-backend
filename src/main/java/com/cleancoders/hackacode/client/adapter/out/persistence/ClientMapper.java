package com.cleancoders.hackacode.client.adapter.out.persistence;

import com.cleancoders.hackacode.client.domain.Client;
import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.user.adapter.out.persistence.UserEntity;
import com.cleancoders.hackacode.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@PersistenceMapper
@Qualifier("clientMapper")
public class ClientMapper implements Mapper<Client, ClientEntity> {

    @Autowired
    @Qualifier("userMapper")
    private Mapper<User, UserEntity> userMapper;


    @Override
    public Client entityToDomain(ClientEntity clientEntity) {
        User user = this.userMapper.entityToDomain(clientEntity.getUser());
        Client client = Client.withUser(user);
        client.setId(clientEntity.getId());
        return client;
    }

    @Override
    public ClientEntity domainToEntity(Client client) {
        return null;
    }
}
