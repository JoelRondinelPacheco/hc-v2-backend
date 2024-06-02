package com.joelrondinelpacheco.hackacode.security.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.security.application.port.in.RoleSelector;
import com.joelrondinelpacheco.hackacode.security.application.port.out.RoleSelectorPort;
import com.joelrondinelpacheco.hackacode.security.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@UseCase
public class RoleSelectorImpl implements RoleSelector {

    @Value("${security.default.role}")
    private String DEFAULT_ROLE;


    private final RoleSelectorPort roleSelectorPort;

    @Autowired
    public RoleSelectorImpl(RoleSelectorPort roleSelectorPort) {
        this.roleSelectorPort = roleSelectorPort;
    }

    @Override
    public Page<Role> getPage(Pageable pageable) {
        return this.roleSelectorPort.getAll(pageable);
    }

    @Override
    public Role getByRoleName(String name) {
        return this.roleSelectorPort.getByName(name);
    }

    @Override
    public Role getById(Long roleId) {
        Role role;
        if (roleId == null) {
            role = this.getByRoleName(DEFAULT_ROLE);
        } else {
            role = this.roleSelectorPort.findById(roleId);
        }
        return role;
    }
}
