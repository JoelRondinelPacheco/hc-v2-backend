package com.joelrondinelpacheco.hackacode.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class User extends UserBase {
    private String password;
}
