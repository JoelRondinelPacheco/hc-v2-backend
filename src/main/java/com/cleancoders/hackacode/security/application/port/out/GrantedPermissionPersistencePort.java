package com.cleancoders.hackacode.security.application.port.out;

import com.cleancoders.hackacode.security.application.dto.grantedpermission.GrantedPermissionDTO;
import com.cleancoders.hackacode.security.domain.GrantedPermission;

public interface GrantedPermissionPersistencePort {
    GrantedPermission addGrantedPermission(GrantedPermissionDTO grantedPermission);
}
