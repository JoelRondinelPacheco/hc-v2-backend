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
                .setName(userDTO.getName())
                .setLastname(userDTO.getLastname())
                .setEmail(userDTO.getEmail())
                .setAddress(userDTO.getAddress())
                .setDni(userDTO.getDni())
                .setBirthday(userDTO.getBirthday())
                .setNationality(userDTO.getNationality())
                .setPhoneNumber(userDTO.getPhoneNumber())
                .build();
    }
}
