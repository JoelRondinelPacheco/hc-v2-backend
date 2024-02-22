package com.cleancoders.hackacode.client.adapter.out.persistence;

import com.cleancoders.hackacode.client.application.port.out.ClientPersistencePort;
import com.cleancoders.hackacode.client.domain.Client;
import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceAdapter
public class ClientPersistenceAdapter implements ClientPersistencePort {

    @Autowired
    private ClientMySQLRepository clientMySQLRepository;
    @Autowired
    @Qualifier("clientMapper")
    private Mapper<Client, ClientEntity> mapper;

    @Override
    public Client save(Client client) {
        ClientEntity clientEntity = this.clientMySQLRepository.save(this.mapper.domainToEntity(client));
        clientEntity.setId(client.getUser().getId());
        return this.mapper.entityToDomain(clientEntity);
    }

    @Override
    public Client update() {
        return null;
    }

    @Override
    public String delete() {
        return null;
    }
}
