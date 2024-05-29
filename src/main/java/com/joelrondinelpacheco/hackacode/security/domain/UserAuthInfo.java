package com.joelrondinelpacheco.hackacode.security.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class UserAuthInfo {
    private String email;
    private String password;
    private Role role;
}
