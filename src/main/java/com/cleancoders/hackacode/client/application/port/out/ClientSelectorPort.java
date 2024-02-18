package com.cleancoders.hackacode.client.application.port.out;

import com.cleancoders.hackacode.client.domain.Client;

public interface ClientSelectorPort {
    Client byId(Long id);
    Client byEmail(String email);
}
