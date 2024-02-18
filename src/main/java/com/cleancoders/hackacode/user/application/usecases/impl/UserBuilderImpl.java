package com.cleancoders.hackacode.user.application.usecases.impl;

import com.cleancoders.hackacode.client.application.dto.NewUserDTO;
import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.user.application.usecases.UserBuilder;
import com.cleancoders.hackacode.user.domain.User;

@UseCase
public class UserBuilderImpl implements UserBuilder {
    @Override
    public User userFromDTO(NewUserDTO userDTO) {
        return new User.UserBuilder()
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
