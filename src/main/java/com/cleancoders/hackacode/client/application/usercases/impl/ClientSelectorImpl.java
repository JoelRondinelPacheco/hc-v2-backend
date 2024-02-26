package com.cleancoders.hackacode.client.application.usercases.impl;

import com.cleancoders.hackacode.client.application.port.in.ClientSelector;
import com.cleancoders.hackacode.client.application.port.out.ClientSelectorPort;
import com.cleancoders.hackacode.client.domain.Client;
import com.cleancoders.hackacode.common.UseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@UseCase
public class ClientSelectorImpl implements ClientSelector {

    @Autowired
    private ClientSelectorPort clientSelector;

    @Override
    public Client byId(Long id) {
        return this.clientSelector.byId(id);
    }

    @Override
    public Client byEmail(String email) {
        return this.clientSelector.byEmail(email);
    }

    @Override
    public Page<Client> getClientsPaginated(Pageable pageable) {
        return null;
    }
}
