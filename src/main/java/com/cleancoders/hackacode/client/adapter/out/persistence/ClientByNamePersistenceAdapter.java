package com.cleancoders.hackacode.client.adapter.out.persistence;

import com.cleancoders.hackacode.client.application.port.out.ClientByNamePort;
import com.cleancoders.hackacode.client.domain.Client;
import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@PersistenceAdapter
public class ClientByNamePersistenceAdapter implements ClientByNamePort {

    @Autowired
    private ClientMySQLRepository clientMySQLRepository;
    @Autowired
    @Qualifier("clientMapper")
    private Mapper<Client, ClientEntity> mapper;

    @Override
    public Page<Client> get(String name, Pageable pageable) {
        return this.clientMySQLRepository.byName(name, pageable).map(this.mapper::entityToDomain);
    }
}
