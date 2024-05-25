package com.cleancoders.hackacode.security.domain;

import com.cleancoders.hackacode.user.domain.User;
import com.cleancoders.hackacode.user.domain.UserBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class JwtToken {
    private Long id;
    private String token;
    private Date expiration;
    private boolean isValid;
    private UserBase user;
}
