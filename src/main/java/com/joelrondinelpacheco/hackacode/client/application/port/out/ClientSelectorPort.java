package com.joelrondinelpacheco.hackacode.client.application.port.out;

import com.joelrondinelpacheco.hackacode.client.domain.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientSelectorPort {
    Client byId(Long id);
    Client byEmail(String email);

    Page<Client> getPage(Pageable pageable);
}
