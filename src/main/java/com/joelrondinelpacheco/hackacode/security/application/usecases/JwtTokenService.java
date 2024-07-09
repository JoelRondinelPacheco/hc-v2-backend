package com.joelrondinelpacheco.hackacode.security.application.usecases;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.Map;

public interface JwtTokenService {
    String generateAuthToken(String username, Map<String, Object> extraClaims);
    String generateVerifyEmailToken(String username);
    String generateRefreshToken(String username, Map<String, Object> extraClaims);
    String extractUsername(String jwt);
    Claims extractAllClaims(String jwt);
    PrivateKey loadPrivateKey(Resource resource);
    PublicKey loadPublicKey(Resource resource);
    String extractJwtFromRequest(HttpServletRequest request);
    Date extractExpiration(String jwt);
    boolean isExpired(String jwt);
    void invalidateToken(String jwt);
}
