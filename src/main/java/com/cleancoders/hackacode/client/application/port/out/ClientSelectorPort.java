package com.cleancoders.hackacode.client.application.port.out;

import com.cleancoders.hackacode.client.domain.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientSelectorPort {
    Client byId(Long id);
    Client byEmail(String email);

    Page<Client> getPage(Pageable pageable);
}
