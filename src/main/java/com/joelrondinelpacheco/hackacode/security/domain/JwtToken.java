package com.joelrondinelpacheco.hackacode.security.domain;

import com.joelrondinelpacheco.hackacode.user.domain.UserBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
