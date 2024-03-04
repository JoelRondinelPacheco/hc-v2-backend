package com.cleancoders.hackacode.security.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.security.application.dto.role.RoleDTO;
import com.cleancoders.hackacode.security.application.port.in.RolePersistence;
import com.cleancoders.hackacode.security.application.port.out.RolePersistencePort;
import com.cleancoders.hackacode.security.domain.Role;
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
