package com.joelrondinelpacheco.hackacode.security.application.port.in;

import com.joelrondinelpacheco.hackacode.security.domain.UserCredentials;

public interface UserCredentialsSelector {
    UserCredentials findByUsername(String username);
}
