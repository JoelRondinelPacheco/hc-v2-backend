package com.joelrondinelpacheco.hackacode.security.application.usecases;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseCookie;

public interface CookiesJWTUseCase {

    ResponseCookie authJwtCookie(String authToken);
    ResponseCookie refreshJwtCookie(String refreshToken);

    String getAuthJwtFromRequest(HttpServletRequest request);
    String getRefreshJwtFromRequest(HttpServletRequest request);

}
