package com.cleancoders.hackacode.security.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.security.application.port.in.RoleSelector;
import com.cleancoders.hackacode.security.application.port.out.RoleSelectorPort;
import com.cleancoders.hackacode.security.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@UseCase
public class RoleSelectorImpl implements RoleSelector {

    @Autowired
    private RoleSelectorPort roleSelectorPort;

    @Override
    public Page<Role> getPage(Pageable pageable) {
        return null;
    }
}
