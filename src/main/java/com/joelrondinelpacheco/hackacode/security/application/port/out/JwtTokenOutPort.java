package com.joelrondinelpacheco.hackacode.security.application.port.out;

import com.joelrondinelpacheco.hackacode.security.domain.JwtToken;

public interface JwtTokenOutPort {
    JwtToken findByToken(String jwt);

    int invalidateToken(String jwt);
}
