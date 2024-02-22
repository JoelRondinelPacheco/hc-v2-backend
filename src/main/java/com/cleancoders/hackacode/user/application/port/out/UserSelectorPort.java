package com.cleancoders.hackacode.user.application.port.out;

import com.cleancoders.hackacode.user.domain.User;

import java.util.List;

public interface UserSelectorPort {
    User byId(Long id);
    User byEmail(String email);

    List<User> getAll();
}
