package com.cleancoders.hackacode.user.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.user.application.port.in.UserSelector;
import com.cleancoders.hackacode.user.application.port.out.UserSelectorPort;
import com.cleancoders.hackacode.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UseCase
public class UserSelectorImpl implements UserSelector {

    @Autowired
    private UserSelectorPort employeeSelector;

    @Override
    public User byId(Long id) {
        return this.employeeSelector.byId(id);
    }

    @Override
    public User byEmail(String email) {
        return this.employeeSelector.byEmail(email);
    }

    @Override
    public List<User> getAll() {
        return this.employeeSelector.getAll();
    }
}
