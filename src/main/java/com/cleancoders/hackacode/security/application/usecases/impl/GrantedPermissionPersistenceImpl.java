package com.cleancoders.hackacode.security.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.security.application.dto.grantedpermission.GrantedPermissionDTO;
import com.cleancoders.hackacode.security.application.port.in.GrantedPermissionPersistence;
import com.cleancoders.hackacode.security.application.port.out.GrantedPermissionPersistencePort;
import com.cleancoders.hackacode.security.domain.GrantedPermission;
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
