package com.joelrondinelpacheco.hackacode.client.application.port.out;

import com.joelrondinelpacheco.hackacode.client.domain.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientByNamePort {

    Page<Client> get(String name, Pageable pageable);
}
