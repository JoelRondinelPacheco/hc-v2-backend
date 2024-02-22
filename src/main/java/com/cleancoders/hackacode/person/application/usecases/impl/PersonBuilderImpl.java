package com.cleancoders.hackacode.person.application.usecases.impl;

import com.cleancoders.hackacode.person.application.dto.NewPersonDTO;
import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.person.application.usecases.PersonBuilder;
import com.cleancoders.hackacode.person.domain.Person;

@UseCase
public class PersonBuilderImpl implements PersonBuilder {
    @Override
    public Person userFromDTO(NewPersonDTO userDTO) {
        return new Person.UserBuilder()
                .name(userDTO.getName())
                .lastname(userDTO.getLastname())
                .email(userDTO.getEmail())
                .address(userDTO.getAddress())
                .dni(userDTO.getDni())
                .birthday(userDTO.getBirthday())
                .nationality(userDTO.getNationality())
                .phoneNumber(userDTO.getPhoneNumber())
                .build();
    }
}
