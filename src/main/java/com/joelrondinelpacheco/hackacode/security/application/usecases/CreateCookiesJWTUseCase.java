package com.joelrondinelpacheco.hackacode.security.application.usecases;

import org.springframework.http.ResponseCookie;

public interface CreateCookiesJWTUseCase {

    ResponseCookie authJwtCookie(String authToken);
    ResponseCookie refreshJwtCookie(String refreshToken);

}
