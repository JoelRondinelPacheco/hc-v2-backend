package com.joelrondinelpacheco.hackacode.security.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.security.application.dto.grantedpermission.GrantedPermissionDTO;
import com.joelrondinelpacheco.hackacode.security.application.port.in.GrantedPermissionPersistence;
import com.joelrondinelpacheco.hackacode.security.application.port.out.GrantedPermissionPersistencePort;
import com.joelrondinelpacheco.hackacode.security.domain.GrantedPermission;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class GrantedPermissionPersistenceImpl implements GrantedPermissionPersistence {

    @Autowired
    private GrantedPermissionPersistencePort grantedPermissionPersistencePort;

    @Override
    public GrantedPermission addGrantedPermission(GrantedPermissionDTO grantedPermission) {
        return null;
    }
}
