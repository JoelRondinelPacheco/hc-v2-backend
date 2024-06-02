package com.joelrondinelpacheco.hackacode.person.domain;

import com.joelrondinelpacheco.hackacode.security.domain.Role;
import com.joelrondinelpacheco.hackacode.security.domain.UserCredentials;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Person {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String address;
    private Integer dni;
    private Date birthday;
    private Integer phoneNumber;
    private UserCredentials userCredentials;
}
