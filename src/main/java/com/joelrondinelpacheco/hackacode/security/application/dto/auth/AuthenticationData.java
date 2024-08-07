package com.joelrondinelpacheco.hackacode.security.application.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AuthenticationData {
    private String authToken;
    private String refreshToken;
    private String name;
    private String lastname;
    private String role;
    private String email;
}
