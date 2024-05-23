package com.cleancoders.hackacode.security.domain;

import com.cleancoders.hackacode.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class JwtToken {
    private Long id;
    private String token;
    private LocalDate expiration;
    private boolean isValid;
    private User user;
}
