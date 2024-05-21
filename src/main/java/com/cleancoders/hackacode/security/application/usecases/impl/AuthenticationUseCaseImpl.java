package com.cleancoders.hackacode.security.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.security.application.dto.auth.AuthenticationRequest;
import com.cleancoders.hackacode.security.application.dto.auth.AuthenticationResponse;
import com.cleancoders.hackacode.security.application.usecases.AuthenticationUseCase;
import com.cleancoders.hackacode.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

@UseCase
public class AuthenticationUseCaseImpl implements AuthenticationUseCase {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public User registerClient() {
        return null;
    }

    @Override
    public AuthenticationResponse login(AuthenticationRequest credentials) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getPassword());
        System.out.println("LOGIN");
        System.out.println(credentials.getPassword());
        System.out.println(authentication.getCredentials());
        this.authenticationManager.authenticate(authentication);

        System.out.println("LOGIN 2");
        return AuthenticationResponse.builder()
                .authToken("asd")
                .refreshToken("asdasd")
                .build();
    }
}
