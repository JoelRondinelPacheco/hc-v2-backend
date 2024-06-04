package com.joelrondinelpacheco.hackacode.security.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.security.application.port.in.UserCredentialsSelector;
import com.joelrondinelpacheco.hackacode.security.application.port.out.UserCredentialsSelectorPort;
import com.joelrondinelpacheco.hackacode.security.domain.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class UserCredentialsSelectorImpl implements UserCredentialsSelector {

    private final UserCredentialsSelectorPort userCredentialsSelectorPort;

    @Autowired
    public UserCredentialsSelectorImpl(UserCredentialsSelectorPort userCredentialsSelectorPort) {
        this.userCredentialsSelectorPort = userCredentialsSelectorPort;
    }

    @Override
    public UserCredentials findByUsername(String username) {
        return this.userCredentialsSelectorPort.findByUsername(username);
    }
}
