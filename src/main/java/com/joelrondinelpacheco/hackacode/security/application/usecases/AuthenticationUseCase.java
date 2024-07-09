package com.joelrondinelpacheco.hackacode.security.application.usecases;

import com.joelrondinelpacheco.hackacode.security.application.dto.auth.AuthenticationRequest;
import com.joelrondinelpacheco.hackacode.security.application.dto.auth.AuthenticationResponse;
import com.joelrondinelpacheco.hackacode.security.application.dto.auth.Token;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface AuthenticationUseCase {
    void logout(HttpServletRequest request);

    AuthenticationResponse login(AuthenticationRequest credentials);

    Token refreshAuthToken(Token body);
}
