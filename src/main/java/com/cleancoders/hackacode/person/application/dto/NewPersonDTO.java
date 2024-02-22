package com.cleancoders.hackacode.person.application.dto;

import com.cleancoders.hackacode.security.domain.Role;
import lombok.Data;

import java.util.Date;

@Data
public class NewPersonDTO {
    private String name;
    private String lastname;
    private String email;
    private String address;
    private Integer dni;
    private Date birthday;
    private String nationality;
    private Integer phoneNumber;
    private Role role;
}
