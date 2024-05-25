package com.cleancoders.hackacode.client.adapter.out.persistence;

import com.cleancoders.hackacode.client.application.port.out.ClientSelectorPort;
import com.cleancoders.hackacode.client.domain.Client;
import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@PersistenceAdapter
public class ClientSelectorAdapter implements ClientSelectorPort {

    @Autowired
    private ClientMySQLRepository clientRepository;

    @Autowired
    @Qualifier("clientMapper")
    private Mapper<Client, ClientEntity> mapper;


    @Override
    public Client byId(Long id) {
        //Optional<ClientEntity> c = this.clientRepository.findById(id);
        return this.clientRepository.findById(id).map(this.mapper::entityToDomain).orElseThrow();
    }

    @Override
    public Client byEmail(String email) {
        return null;
    }

    @Override
    public Page<Client> getPage(Pageable pageable) {
        return this.clientRepository.findAll(pageable).map(this.mapper::entityToDomain);
    }

    public ClientEntity entityById(Long id) {
        return this.clientRepository.findById(id).orElseThrow();
    }
}
