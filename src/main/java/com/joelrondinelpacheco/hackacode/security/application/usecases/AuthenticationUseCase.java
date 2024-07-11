package com.joelrondinelpacheco.hackacode.security.application.usecases;

import com.joelrondinelpacheco.hackacode.security.application.dto.auth.AuthenticationRequest;
import com.joelrondinelpacheco.hackacode.security.application.dto.auth.AuthenticationData;
import com.joelrondinelpacheco.hackacode.security.application.dto.auth.Token;
import jakarta.servlet.http.HttpServletRequest;

public interface AuthenticationUseCase {
    void logout(HttpServletRequest request);

    AuthenticationData login(AuthenticationRequest credentials);

    Token refreshAuthToken(HttpServletRequest req);
}
