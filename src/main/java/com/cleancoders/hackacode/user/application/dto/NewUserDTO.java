package com.cleancoders.hackacode.user.application.dto;

import com.cleancoders.hackacode.security.domain.Role;
import lombok.Data;

import java.util.Date;

@Data
public class NewUserDTO {
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
