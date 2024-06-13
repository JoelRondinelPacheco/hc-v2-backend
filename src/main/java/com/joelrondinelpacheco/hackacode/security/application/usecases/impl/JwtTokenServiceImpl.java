package com.joelrondinelpacheco.hackacode.security.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.security.application.usecases.JwtTokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@UseCase
public class JwtTokenServiceImpl implements JwtTokenService {

    @Value("classpath:jwtKeys/private_key.pem") private Resource privateKeyResource;
    @Value("classpath:jwtKeys/public_key.pem") private Resource publicKeyResource;

    @Value("${security.jwt.expiration-in-minutes.auth}")
    private Long AUTH_EXPIRATION_IN_MINUTES;
    @Value("${security.jwt.expiration-in-minutes.validate-account}")
    private Long VALIDATE_ACCOUNT_EXPIRATION_IN_MINUTES;


    @Override
    public String generateAuthToken(String username, Map<String, Object> extraClaims) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
        Date issuedAt = new Date(System.currentTimeMillis());
        Date expiration = this.generateExpirationDate(issuedAt, AUTH_EXPIRATION_IN_MINUTES);

        return Jwts.builder()
                .header()
                    .type("JWT")
                    .and()
                .subject(username)
                .issuedAt(issuedAt)
                .expiration(expiration)
                .claims(extraClaims)
                .signWith(loadPrivateKey(privateKeyResource))
                .compact();
    }

    @Override
    public String generateVerifyEmailToken(String username) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
        Date issuedAt = new Date(System.currentTimeMillis());
        Date expiration = this.generateExpirationDate(issuedAt, VALIDATE_ACCOUNT_EXPIRATION_IN_MINUTES);

        return Jwts.builder()
                .header()
                    .type("VALIDATE_ACCOUNT")
                    .and()
                .subject(username)
                .issuedAt(issuedAt)
                .expiration(expiration)
                .signWith(loadPrivateKey(privateKeyResource))
                .compact();
    }

    @Override
    public String extractUsername(String jwt) {
        return extractAllClaims(jwt).getSubject();
    }

    @Override
    public Claims extractAllClaims(String jwt) {
        try {
            return Jwts.parser().verifyWith(loadPublicKey(publicKeyResource)).build().parseSignedClaims(jwt).getPayload();
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PrivateKey loadPrivateKey(Resource resource) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
        InputStream inputStream = resource.getInputStream();
        byte[] keyBytes = inputStream.readAllBytes();

        //keyBytes = Files.readAllBytes(Paths.get(resource.getURI()));

        String privateKeyPEM = new String(keyBytes, StandardCharsets.UTF_8)
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s", "");
        byte[] decodeKey = Base64.getDecoder().decode(privateKeyPEM);

        KeyFactory keyFactory =  KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decodeKey));
    }

    @Override
    public PublicKey loadPublicKey(Resource resource) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        InputStream inputStream = resource.getInputStream();
        byte[] keyBytes = inputStream.readAllBytes();
        String publicKeyPEM = new String(keyBytes, StandardCharsets.UTF_8)
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s", "");

        byte[] decodeKey = Base64.getDecoder().decode(publicKeyPEM);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(new X509EncodedKeySpec(decodeKey));
    }

    @Override
    public String extractJwtFromRequest(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (!StringUtils.hasText(authorizationHeader) || !authorizationHeader.startsWith("Bearer ")) {
            return null;
        }
        return authorizationHeader.split(" ")[1];
    }

    @Override
    public Date extractExpiration(String jwt){
            return this.extractAllClaims(jwt).getExpiration();
    }

    @Override
    public boolean isExpired(String jwt) {
        Date current = new Date();
        Date expirationDate = this.extractExpiration(jwt);

        return expirationDate.before(current);
    }

    @Override
    public void invalidateToken(String jwt) {

        /*
        TODO IMPLEMENT
        int token = this.jwtTokenOutPort.invalidateToken(jwt);
        if (token == 0) {
            //TODO THROW EXP
        }*/
    }

    private Date generateExpirationDate(Date issuedAt, Long expirationInMinutes) {
        return new Date((expirationInMinutes * 60 * 1000) + issuedAt.getTime());
    }

}
