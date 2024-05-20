package com.cleancoders.hackacode.security.domain;

import com.cleancoders.hackacode.user.domain.User;

import java.time.LocalDate;

public class JwtToken {
    private Long id;
    private String token;
    private LocalDate expiration;
    private boolean isValid;
    private User user;
}
