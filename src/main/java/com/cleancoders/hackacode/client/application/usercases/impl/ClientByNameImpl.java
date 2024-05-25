package com.cleancoders.hackacode.client.application.usercases.impl;

import com.cleancoders.hackacode.client.application.port.in.ClientByName;
import com.cleancoders.hackacode.client.application.port.out.ClientByNamePort;
import com.cleancoders.hackacode.client.domain.Client;
import com.cleancoders.hackacode.common.UseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@UseCase
public class ClientByNameImpl implements ClientByName {

    @Autowired
    private ClientByNamePort clientByNamePort;

    @Override
    public Page<Client> get(String name, Pageable pageable) {
        return this.clientByNamePort.get(name, pageable);
    }
}
