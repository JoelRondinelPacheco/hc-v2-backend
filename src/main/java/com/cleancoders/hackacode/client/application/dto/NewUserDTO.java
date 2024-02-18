package com.cleancoders.hackacode.client.application.dto;

import com.cleancoders.hackacode.security.domain.Role;

import java.util.Date;

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

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public Integer getDni() {
        return dni;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getNationality() {
        return nationality;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public Role getRole() {
        return role;
    }
}
