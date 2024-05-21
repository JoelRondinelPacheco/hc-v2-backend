package com.cleancoders.hackacode.security.application.usecases;

import com.cleancoders.hackacode.security.application.dto.auth.AuthenticationRequest;
import com.cleancoders.hackacode.security.application.dto.auth.AuthenticationResponse;
import com.cleancoders.hackacode.user.domain.User;

public interface AuthenticationUseCase {
    public User registerClient();

    public AuthenticationResponse login(AuthenticationRequest credentials);

}
