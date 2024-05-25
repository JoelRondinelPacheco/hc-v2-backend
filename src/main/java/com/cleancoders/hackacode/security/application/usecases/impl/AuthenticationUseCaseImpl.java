package com.cleancoders.hackacode.security.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.security.application.dto.auth.AuthenticationRequest;
import com.cleancoders.hackacode.security.application.dto.auth.AuthenticationResponse;
import com.cleancoders.hackacode.security.application.dto.user.UserDetailsDTO;
import com.cleancoders.hackacode.security.application.usecases.AuthenticationUseCase;
import com.cleancoders.hackacode.security.application.usecases.CustomUsersDetailsUseCase;
import com.cleancoders.hackacode.security.application.usecases.JwtTokenService;
import com.cleancoders.hackacode.security.domain.JwtToken;
import com.cleancoders.hackacode.user.domain.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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
    private CustomUsersDetailsUseCase userDetailsService;

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

        UserDetailsDTO userDetails = this.userDetailsService.getUserDetails(credentials.getEmail());

        String jwt = this.jwtTokenService.generateToken(credentials.getEmail(), generateExtraClaims(userDetails));

        return AuthenticationResponse.builder()
                .authToken(jwt)
                .refreshToken("")
                .build();
    }

    private Map<String, Object> generateExtraClaims(UserDetailsDTO user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", user.getUsername());
        extraClaims.put("role", user.getRole().getName());
        extraClaims.put("authorities", user.getAuthorities());
        return extraClaims;
    }
}
