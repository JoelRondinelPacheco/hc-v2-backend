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
    String generateAuthToken(String username, Map<String, Object> extraClaims) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException;
    String generateVerifyEmailToken(String username) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException;
    String extractUsername(String jwt);
    Claims extractAllClaims(String jwt) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException;
    PrivateKey loadPrivateKey(Resource resource) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException;
    PublicKey loadPublicKey(Resource resource) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException;
    String extractJwtFromRequest(HttpServletRequest request);
    Date extractExpiration(String jwt);
    boolean isExpired(String jwt);
    void invalidateToken(String jwt);
}
