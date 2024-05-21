package com.cleancoders.hackacode.security.application.usecases;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.Resource;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.Map;

public interface JwtTokenService {
    String generateToken(UserDetails user, Map<String, Object> extraClaims) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException;
    String extractUsername(String jwt) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException;
    Claims extractAllClaims(String jwt) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException;
    PrivateKey loadPrivateKey(Resource resource) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException;
    PublicKey loadPublicKey(Resource resource) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException;
    String extractJwtFromRequest(HttpServletRequest request);
    Date extractExpiration(String jwt) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException;
}
