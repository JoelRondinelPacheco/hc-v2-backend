package com.cleancoders.hackacode.user.domain;

import com.cleancoders.hackacode.security.domain.Role;

import java.util.Date;

public class User {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String address;
    private Integer dni;
    private Date birthday;
    private String nationality;
    private Integer phoneNumber;
    private Role role;


    public User(UserBuilder userBuilder) {
        this.name = userBuilder.name;
        this.lastname = userBuilder.lastname;
        this.email = userBuilder.email;
        this.address = userBuilder.address;
        this.dni = userBuilder.dni;
        this.birthday = userBuilder.birthday;
        this.nationality = userBuilder.nationality;
        this.phoneNumber = userBuilder.phoneNumber;
    }


    public static class UserBuilder {
        private String name;
        private String lastname;
        private String email;
        private String address;
        private Integer dni;
        private Date birthday;
        private String nationality;
        private Integer phoneNumber;

        public UserBuilder() {}

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder setDni(Integer dni) {
            this.dni = dni;
            return this;
        }

        public UserBuilder setBirthday(Date birthday) {
            this.birthday = birthday;
            return this;
        }

        public UserBuilder setNationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        public UserBuilder setPhoneNumber(Integer phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }


}
