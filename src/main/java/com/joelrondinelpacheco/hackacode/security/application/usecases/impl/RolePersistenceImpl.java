package com.joelrondinelpacheco.hackacode.security.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.security.application.dto.role.RoleDTO;
import com.joelrondinelpacheco.hackacode.security.application.port.in.RolePersistence;
import com.joelrondinelpacheco.hackacode.security.application.port.out.RolePersistencePort;
import com.joelrondinelpacheco.hackacode.security.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class RolePersistenceImpl implements RolePersistence {

    @Autowired
    private RolePersistencePort rolePersistencePort;

    @Override
    public Role addRole(RoleDTO body) {
        return null;
    }
}
