package com.joelrondinelpacheco.hackacode.security.application.port.in;

import com.joelrondinelpacheco.hackacode.security.application.dto.grantedpermission.GrantedPermissionDTO;
import com.joelrondinelpacheco.hackacode.security.domain.GrantedPermission;

public interface GrantedPermissionPersistence {
    GrantedPermission addGrantedPermission(GrantedPermissionDTO grantedPermission);
}
