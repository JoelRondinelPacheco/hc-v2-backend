package com.joelrondinelpacheco.hackacode.security.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.security.application.port.in.RoleSelector;
import com.joelrondinelpacheco.hackacode.security.application.port.out.RoleSelectorPort;
import com.joelrondinelpacheco.hackacode.security.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@UseCase
public class RoleSelectorImpl implements RoleSelector {

    @Autowired
    private RoleSelectorPort roleSelectorPort;

    @Override
    public Page<Role> getPage(Pageable pageable) {
        return this.roleSelectorPort.getAll(pageable);
    }
}
