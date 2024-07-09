package com.joelrondinelpacheco.hackacode.security.application.usecases;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;

@UseCase
public class CreateCookiesJWTUseCaseImpl implements CreateCookiesJWTUseCase{


    @Value("${server.servlet.context-path}")
    private String API_BASE_PATH;
    @Value("${hcv2.app.jwt-cookie-name}")
    private String JWT_COOKIE;
    @Value("${hcv2.app.jwt-refresh-cookie-name}")
    private String JWT_REFRESH_COOKIE;

    @Override
    public ResponseCookie authJwtCookie(String authToken) {
        return this.generateCookie(JWT_COOKIE, authToken, API_BASE_PATH);
    }

    @Override
    public ResponseCookie refreshJwtCookie(String refreshToken) {
        return this.generateCookie(JWT_COOKIE, refreshToken, API_BASE_PATH.concat("/auth/refresh"));
    }

    private ResponseCookie generateCookie(String name, String jwt, String path) {
        return ResponseCookie.from(name, jwt).path(path).maxAge(24 * 60 * 60).httpOnly(true).build();
    }
}
