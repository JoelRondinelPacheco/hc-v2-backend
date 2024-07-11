package com.joelrondinelpacheco.hackacode.security.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.security.application.dto.auth.AuthenticationRequest;
import com.joelrondinelpacheco.hackacode.security.application.dto.auth.AuthenticationData;
import com.joelrondinelpacheco.hackacode.security.application.dto.auth.Token;
import com.joelrondinelpacheco.hackacode.security.application.entity.CustomUserDetails;
import com.joelrondinelpacheco.hackacode.security.application.usecases.AuthenticationUseCase;
import com.joelrondinelpacheco.hackacode.security.application.usecases.CookiesJWTUseCase;
import com.joelrondinelpacheco.hackacode.security.application.usecases.CustomUsersDetailsService;
import com.joelrondinelpacheco.hackacode.security.application.usecases.JwtTokenService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@UseCase
public class AuthenticationUseCaseImpl implements AuthenticationUseCase {


    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;
    private final CustomUsersDetailsService userDetailsService;
    private final CookiesJWTUseCase cookiesJWTUseCase;

    @Autowired
    public AuthenticationUseCaseImpl(AuthenticationManager authenticationManager, JwtTokenService jwtTokenService, CustomUsersDetailsService userDetailsService, CookiesJWTUseCase cookiesJWTUseCase) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
        this.userDetailsService = userDetailsService;
        this.cookiesJWTUseCase = cookiesJWTUseCase;
    }

    @Override
    public void logout(HttpServletRequest request) {
        String jwt = this.jwtTokenService.extractJwtFromRequest(request);
        if (jwt == null || !StringUtils.hasText(jwt)) return;

        this.jwtTokenService.invalidateToken(jwt);
    }

    @Override
    public AuthenticationData login(AuthenticationRequest credentials) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getPassword());
        this.authenticationManager.authenticate(authentication);

        CustomUserDetails userDetails = this.userDetailsService.getUserDetails(credentials.getEmail());

        String jwt = this.jwtTokenService.generateAuthToken(credentials.getEmail(), generateExtraClaims(userDetails));
        String refreshJwt = this.jwtTokenService.generateRefreshToken(credentials.getEmail(), generateExtraClaims(userDetails));

        return AuthenticationData.builder()
                .name(userDetails.getPerson().getName())
                .lastname(userDetails.getPerson().getLastname())
                .authToken(jwt)
                .refreshToken(refreshJwt)
                .email(userDetails.getUsername())
                .role(userDetails.getRole().getName().toUpperCase())
                .build();
    }

    @Override
    public Token refreshAuthToken(HttpServletRequest req) {
       String jwt = this.cookiesJWTUseCase.getRefreshJwtFromRequest(req);
       String username = this.jwtTokenService.extractUsername(jwt);
        CustomUserDetails userDetails = this.userDetailsService.getUserDetails(username);

        String authToken = this.jwtTokenService.generateAuthToken(username, generateExtraClaims((userDetails)));

        return new Token(authToken);
    }

    private Map<String, Object> generateExtraClaims(CustomUserDetails user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", user.getUsername());
        extraClaims.put("role", user.getRole().getName());
        extraClaims.put("authorities", user.getAuthorities());
        return extraClaims;
    }
}
