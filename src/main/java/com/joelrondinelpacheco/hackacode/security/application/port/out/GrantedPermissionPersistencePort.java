package com.joelrondinelpacheco.hackacode.security.application.port.out;

import com.joelrondinelpacheco.hackacode.security.application.dto.grantedpermission.GrantedPermissionDTO;
import com.joelrondinelpacheco.hackacode.security.domain.GrantedPermission;

public interface GrantedPermissionPersistencePort {
    GrantedPermission addGrantedPermission(GrantedPermissionDTO grantedPermission);
}
