package com.joelrondinelpacheco.hackacode.security.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.security.application.dto.grantedpermission.GrantedPermissionDTO;
import com.joelrondinelpacheco.hackacode.security.application.dto.module.ModuleDTO;
import com.joelrondinelpacheco.hackacode.security.application.dto.operation.OperationDTO;
import com.joelrondinelpacheco.hackacode.security.application.dto.role.RoleDTO;
import com.joelrondinelpacheco.hackacode.security.application.port.in.SecurityConfigPersistence;
import com.joelrondinelpacheco.hackacode.security.domain.GrantedPermission;
import com.joelrondinelpacheco.hackacode.security.domain.Operation;
import com.joelrondinelpacheco.hackacode.security.domain.Role;


@UseCase
public class SecurityPersistenceImpl implements SecurityConfigPersistence {
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
