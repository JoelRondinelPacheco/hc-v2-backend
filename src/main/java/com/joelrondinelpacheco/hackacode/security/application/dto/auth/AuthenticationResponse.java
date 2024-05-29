package com.joelrondinelpacheco.hackacode.security.application.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AuthenticationResponse {
    private String authToken;
    private String refreshToken;
}
