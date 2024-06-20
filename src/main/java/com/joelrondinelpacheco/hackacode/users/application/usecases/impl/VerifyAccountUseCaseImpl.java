package com.joelrondinelpacheco.hackacode.users.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.security.application.port.in.UserCredentialsSelector;
import com.joelrondinelpacheco.hackacode.security.application.port.in.UserCredentialsService;
import com.joelrondinelpacheco.hackacode.security.application.usecases.JwtTokenService;
import com.joelrondinelpacheco.hackacode.security.domain.UserCredentials;
import com.joelrondinelpacheco.hackacode.users.application.port.in.VerifyAccountUseCase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@UseCase
public class VerifyAccountUseCaseImpl implements VerifyAccountUseCase {

    private final JwtTokenService jwtTokenService;
    private final UserCredentialsService userCredentialsService;
    private final UserCredentialsSelector userCredentialsSelector;

    @Autowired
    public VerifyAccountUseCaseImpl(JwtTokenService jwtTokenService, UserCredentialsService userCredentialsService, UserCredentialsSelector userCredentialsSelector) {
        this.jwtTokenService = jwtTokenService;
        this.userCredentialsService = userCredentialsService;
        this.userCredentialsSelector = userCredentialsSelector;
    }

    @Override
    public String verify(String token) {
        String email = this.jwtTokenService.extractUsername(token);
        UserCredentials userCredentials = this.userCredentialsSelector.findByUsername(email);

        this.verifyCredentialsToken(userCredentials, token);
        this.userCredentialsService.verifyCredentialsNonExpired(userCredentials);
        this.userCredentialsService.verifyAccountNonLocked(userCredentials);
        //todo verificar el tipo IMPORTANTE

        //todo ver como hacer con refresh token
        userCredentials.setCredentialsNonExpired(false);
        userCredentials.setEnabled(true);
        this.userCredentialsService.saveUserCredentials(userCredentials);

        return "Account verified";
    }

    private void verifyCredentialsToken(UserCredentials credentials, String token) {
        if (!token.equals(credentials.getEmailToken())) {
            throw new RuntimeException("Todo invalid toke ex");
        }
    }
}
