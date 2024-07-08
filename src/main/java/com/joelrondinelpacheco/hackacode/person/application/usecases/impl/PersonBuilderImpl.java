package com.joelrondinelpacheco.hackacode.person.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.person.application.dto.NewClientDTO;
import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.person.application.usecases.PersonBuilder;
import com.joelrondinelpacheco.hackacode.person.domain.Person;

@UseCase
public class PersonBuilderImpl implements PersonBuilder {
    @Override
    public Person userFromDTO(NewClientDTO userDTO) {
        return Person.builder()
                .name(userDTO.getName())
                .lastname(userDTO.getLastname())
                .email(userDTO.getEmail())
                .address(userDTO.getAddress())
                .dni(userDTO.getDni())
                .birthday(userDTO.getBirthday())
                .phoneNumber(userDTO.getPhoneNumber())
                .build();
    }
}
