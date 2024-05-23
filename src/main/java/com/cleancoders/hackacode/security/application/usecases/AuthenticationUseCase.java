package com.cleancoders.hackacode.security.application.usecases;

import com.cleancoders.hackacode.security.application.dto.auth.AuthenticationRequest;
import com.cleancoders.hackacode.security.application.dto.auth.AuthenticationResponse;
import com.cleancoders.hackacode.user.domain.User;
import jakarta.servlet.http.HttpServletRequest;

public interface AuthenticationUseCase {
    void logout(HttpServletRequest request);

    AuthenticationResponse login(AuthenticationRequest credentials);

}
