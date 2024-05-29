package com.joelrondinelpacheco.hackacode.user.application.port.out;

import com.joelrondinelpacheco.hackacode.user.domain.User;
import com.joelrondinelpacheco.hackacode.user.domain.UserBase;

public interface UserPersistencePort {

    UserBase registerUser(User user);
}
