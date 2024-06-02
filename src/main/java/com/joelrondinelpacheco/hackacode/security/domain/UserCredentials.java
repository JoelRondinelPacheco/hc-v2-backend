package com.joelrondinelpacheco.hackacode.security.domain;

import com.joelrondinelpacheco.hackacode.person.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class UserCredentials {
    private String email;
    private String password;
    private Role role;
    private Person person;
}
