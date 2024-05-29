package com.joelrondinelpacheco.hackacode.user.adapter.out.persistence.mapper;

import com.joelrondinelpacheco.hackacode.common.adapter.Mapper;
import com.joelrondinelpacheco.hackacode.user.adapter.out.persistence.UserEntity;
import com.joelrondinelpacheco.hackacode.user.domain.User;

public interface UserMapper extends Mapper<User, UserEntity> {
   // UserBase entityToUserBase(UserEntity userEntity);
}
