package com.cleancoders.hackacode.security.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.security.application.port.out.JwtTokenOutPort;
import com.cleancoders.hackacode.security.application.usecases.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class JwtTokenServiceImpl implements JwtTokenService {
    @Autowired
    private JwtTokenOutPort jwtTokenOutPort;
}
