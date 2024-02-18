package com.cleancoders.hackacode.user.application.port.in;

import com.cleancoders.hackacode.user.domain.User;

public interface UserPersistence {
    User save(User user);
    User update(User user);
    String delete(Long userId);
}
