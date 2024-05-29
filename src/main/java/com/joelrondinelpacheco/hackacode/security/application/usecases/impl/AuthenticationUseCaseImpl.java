package com.joelrondinelpacheco.hackacode.security.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.security.application.dto.auth.AuthenticationRequest;
import com.joelrondinelpacheco.hackacode.security.application.dto.auth.AuthenticationResponse;
import com.joelrondinelpacheco.hackacode.security.application.entity.CustomUserDetails;
import com.joelrondinelpacheco.hackacode.security.application.usecases.AuthenticationUseCase;
import com.joelrondinelpacheco.hackacode.security.application.usecases.CustomUsersDetailsService;
import com.joelrondinelpacheco.hackacode.security.application.usecases.JwtTokenService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

@UseCase
public class AuthenticationUseCaseImpl implements AuthenticationUseCase {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private CustomUsersDetailsService userDetailsService;

    @Override
    public void logout(HttpServletRequest request) {
        String jwt = this.jwtTokenService.extractJwtFromRequest(request);
        if (jwt == null || !StringUtils.hasText(jwt)) return;

        this.jwtTokenService.invalidateToken(jwt);
    }

    @Override
    public AuthenticationResponse login(AuthenticationRequest credentials) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
        Authentication authentication = new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getPassword());
        this.authenticationManager.authenticate(authentication);

        CustomUserDetails userDetails = this.userDetailsService.getUserDetails(credentials.getEmail());

        String jwt = this.jwtTokenService.generateToken(credentials.getEmail(), generateExtraClaims(userDetails));

        return AuthenticationResponse.builder()
                .authToken(jwt)
                .refreshToken("")
                .build();
    }

    private Map<String, Object> generateExtraClaims(CustomUserDetails user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", user.getUsername());
        extraClaims.put("role", user.getRole().getName());
        extraClaims.put("authorities", user.getAuthorities());
        return extraClaims;
    }
}
