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

        return null;
    }

    @Override
    public UserEntity domainToEntity(User user) {
        return null;
    }
}
