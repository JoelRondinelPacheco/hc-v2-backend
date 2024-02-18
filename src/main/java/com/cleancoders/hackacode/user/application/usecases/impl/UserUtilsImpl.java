package com.cleancoders.hackacode.user.application.usecases.impl;

import com.cleancoders.hackacode.client.application.dto.NewUserDTO;
import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.user.application.port.in.UserUtils;
import com.cleancoders.hackacode.user.application.port.out.UserPersistencePort;
import com.cleancoders.hackacode.user.application.port.out.UserUtilsPort;
import com.cleancoders.hackacode.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class UserUtilsImpl implements UserUtils {

    @Autowired
    private UserUtilsPort userUtilsRepository;
    @Autowired
    private UserPersistencePort userRepository;

    @Override
    public void existsByEmail(String email) {
        if(this.userUtilsRepository.existsByEmail(email)) {
            throw new RuntimeException("TODO CUSTOM EX");
        }
    }

    @Override
    public User userFromDTO(NewUserDTO userDTO) {

        User user = new User.UserBuilder()
                .setName(userDTO.getName())
                .setLastname(userDTO.getLastname())
                .setEmail(userDTO.getEmail())
                .setAddress(userDTO.getAddress())
                .setDni(userDTO.getDni())
                .setBirthday(userDTO.getBirthday())
                .setNationality(userDTO.getNationality())
                .setPhoneNumber(userDTO.getPhoneNumber())
                .build();

        return this.userRepository.save(user);
    }
}
