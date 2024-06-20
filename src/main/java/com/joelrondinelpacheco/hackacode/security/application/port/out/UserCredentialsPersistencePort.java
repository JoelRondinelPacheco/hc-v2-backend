package com.joelrondinelpacheco.hackacode.security.application.port.out;

import com.joelrondinelpacheco.hackacode.security.application.entity.CustomUserDetails;
import com.joelrondinelpacheco.hackacode.security.domain.UserCredentials;

import java.util.Optional;

public interface UserCredentialsPersistencePort {
    UserCredentials save(UserCredentials userCredentials);

    Optional<CustomUserDetails> getUserDetails(String email);
}
