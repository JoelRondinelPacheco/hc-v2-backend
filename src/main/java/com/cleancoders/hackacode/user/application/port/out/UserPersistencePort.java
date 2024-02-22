package com.cleancoders.hackacode.user.application.port.out;

import com.cleancoders.hackacode.user.domain.User;

public interface UserPersistencePort {

    User save(User user);
}
