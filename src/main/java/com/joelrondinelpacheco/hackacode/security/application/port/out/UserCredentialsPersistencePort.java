package com.joelrondinelpacheco.hackacode.security.application.port.out;

import com.joelrondinelpacheco.hackacode.security.domain.UserCredentials;

public interface UserCredentialsPersistencePort {
    UserCredentials save(UserCredentials userCredentials);
}
