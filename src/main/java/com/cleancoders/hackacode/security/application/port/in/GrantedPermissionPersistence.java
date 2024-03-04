package com.cleancoders.hackacode.security.application.port.in;

import com.cleancoders.hackacode.security.application.dto.grantedpermission.GrantedPermissionDTO;
import com.cleancoders.hackacode.security.domain.GrantedPermission;

public interface GrantedPermissionPersistence {
    GrantedPermission addGrantedPermission(GrantedPermissionDTO grantedPermission);
}
