package com.cleancoders.hackacode.user.application.port.out;

import com.cleancoders.hackacode.user.domain.User;
import com.cleancoders.hackacode.user.domain.UserBase;

public interface UserPersistencePort {

    UserBase registerUser(User user);
}
