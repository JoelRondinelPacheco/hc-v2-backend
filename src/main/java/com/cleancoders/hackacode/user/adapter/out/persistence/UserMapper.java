package com.cleancoders.hackacode.user.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.user.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceMapper
@Qualifier("userMapper")
public class UserMapper implements Mapper<User, UserEntity> {

    @Override
    public User entityToDomain(UserEntity userEntity) {
        return new User.UserBuilder()
                .name(userEntity.getName())
                .lastname(userEntity.getLastname())
                .email(userEntity.getEmail())
                .address(userEntity.getAddress())
                .dni(userEntity.getDni())
                .birthday(userEntity.getBirthday())
                .nationality(userEntity.getNationality())
                .phoneNumber(userEntity.getPhoneNumber())
                .build();
    }

    @Override
    public UserEntity domainToEntity(User user) {
        return   UserEntity.builder()
                .name(user.getName())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .address(user.getAddress())
                .dni(user.getDni())
                .birthday(user.getBirthday())
                .nationality(user.getNationality())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
