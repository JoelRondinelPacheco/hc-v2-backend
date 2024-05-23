package com.cleancoders.hackacode.security.application.port.out;

import com.cleancoders.hackacode.security.domain.JwtToken;

public interface JwtTokenOutPort {
    JwtToken findByToken(String jwt);

    int invalidateToken(String jwt);
}
