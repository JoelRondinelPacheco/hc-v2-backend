package com.cleancoders.hackacode.client.application.port.in;

import com.cleancoders.hackacode.client.domain.Client;

public interface ClientSelector {
    Client byId(Long id);
    Client byEmail(String email);
}
