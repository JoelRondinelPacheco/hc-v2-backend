package com.cleancoders.hackacode.user.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.user.adapter.out.persistence.UserEntity;
import com.cleancoders.hackacode.user.domain.User;

public interface UserMapper extends Mapper<User, UserEntity> {
   // UserBase entityToUserBase(UserEntity userEntity);
}
