package com.joelrondinelpacheco.hackacode.client.application.port.in;

import com.joelrondinelpacheco.hackacode.client.domain.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientByName {
    Page<Client> get(String name, Pageable pageable);
}
