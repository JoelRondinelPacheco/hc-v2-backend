package com.joelrondinelpacheco.hackacode.security.application.port.out;

import com.joelrondinelpacheco.hackacode.security.domain.UserCredentials;

public interface UserCredentialsSelectorPort {
    UserCredentials findByUsername(String username);
}
