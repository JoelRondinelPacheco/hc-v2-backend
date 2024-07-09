package com.joelrondinelpacheco.hackacode.security.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.security.application.usecases.CookiesJWTUseCase;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.web.util.WebUtils;

@UseCase
public class CookiesJWTUseCaseImpl implements CookiesJWTUseCase {


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
        return this.generateCookie(JWT_REFRESH_COOKIE, refreshToken, API_BASE_PATH.concat("/auth/refresh"));
    }

    @Override
    public String getAuthJwtFromRequest(HttpServletRequest request) {
        return this.getTokenFromCookieByName(request, JWT_COOKIE);
    }

    @Override
    public String getRefreshJwtFromRequest(HttpServletRequest request) {
        return this.getTokenFromCookieByName(request, JWT_REFRESH_COOKIE);
    }

    private ResponseCookie generateCookie(String name, String jwt, String path) {
        return ResponseCookie.from(name, jwt).path(path).maxAge(24 * 60 * 60).httpOnly(true).build();
    }

    private String getTokenFromCookieByName(HttpServletRequest request, String name) {
        Cookie cookie = WebUtils.getCookie(request, name);
        if (cookie != null) {
            return cookie.getValue();
        } else {
            return null; //todo trow ex??
        }
    }
}
