package com.cleancoders.hackacode.security.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.security.application.dto.grantedpermission.GrantedPermissionDTO;
import com.cleancoders.hackacode.security.application.dto.module.ModuleDTO;
import com.cleancoders.hackacode.security.application.dto.operation.OperationDTO;
import com.cleancoders.hackacode.security.application.dto.role.RoleDTO;
import com.cleancoders.hackacode.security.application.port.in.SecurityConfigPersistence;
import com.cleancoders.hackacode.security.application.port.out.SecurityConfigPersistencePort;
import com.cleancoders.hackacode.security.domain.GrantedPermission;
import com.cleancoders.hackacode.security.domain.Operation;
import com.cleancoders.hackacode.security.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;


@UseCase
public class SecurityConfigPersistenceImpl implements SecurityConfigPersistence {
/*
    @Autowired
    private SecurityConfigPersistencePort securityRepository;*/

    @Override
    public Role addRole(RoleDTO role) {
        return null;
    }

    @Override
    public Module createModule(ModuleDTO moduleDTO) {
        return null;
    }

    @Override
    public Operation createOperation(OperationDTO operation) {
        return null;
    }

    @Override
    public GrantedPermission createGrantedPermission(GrantedPermissionDTO grantedPermission) {
        return null;
    }

    @Override
    public Role createRole(RoleDTO role) {
        return null;
    }
}
