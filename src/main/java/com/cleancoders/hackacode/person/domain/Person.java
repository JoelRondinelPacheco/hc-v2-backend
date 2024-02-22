package com.cleancoders.hackacode.person.domain;

import com.cleancoders.hackacode.security.domain.Role;
import lombok.Data;

import java.util.Date;

@Data
public class Person {
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


    public Person(UserBuilder userBuilder) {
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

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder dni(Integer dni) {
            this.dni = dni;
            return this;
        }

        public UserBuilder birthday(Date birthday) {
            this.birthday = birthday;
            return this;
        }

        public UserBuilder nationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        public UserBuilder phoneNumber(Integer phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }


}
