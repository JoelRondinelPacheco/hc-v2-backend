package com.cleancoders.hackacode.client.application.port.out;

import com.cleancoders.hackacode.client.domain.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientByNamePort {

    Page<Client> get(String name, Pageable pageable);
}
