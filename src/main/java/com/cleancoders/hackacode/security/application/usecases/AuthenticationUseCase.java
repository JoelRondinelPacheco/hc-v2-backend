package com.cleancoders.hackacode.security.application.usecases;

import com.cleancoders.hackacode.security.application.dto.auth.AuthenticationRequest;
import com.cleancoders.hackacode.security.application.dto.auth.AuthenticationResponse;
import com.cleancoders.hackacode.user.domain.User;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface AuthenticationUseCase {
    void logout(HttpServletRequest request);

    AuthenticationResponse login(AuthenticationRequest credentials) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException;

}
