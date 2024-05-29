package com.joelrondinelpacheco.hackacode.user.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.user.application.port.in.UserSelector;
import com.joelrondinelpacheco.hackacode.user.application.port.out.UserSelectorPort;
import com.joelrondinelpacheco.hackacode.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
    public Page<User> getPage(Pageable pageable) {
        return this.employeeSelector.getPage(pageable);
    }
}
