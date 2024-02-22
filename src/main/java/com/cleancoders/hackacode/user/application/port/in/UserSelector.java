package com.cleancoders.hackacode.user.application.port.in;

import com.cleancoders.hackacode.user.domain.User;

import java.util.List;

public interface UserSelector {
    User byId(Long id);
    User byEmail(String email);

    List<User> getAll();
}
