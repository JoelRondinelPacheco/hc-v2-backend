package com.cleancoders.hackacode.security.application.port.in;

import com.cleancoders.hackacode.security.application.dto.grantedpermission.GrantedPermissionDTO;
import com.cleancoders.hackacode.security.application.dto.module.ModuleDTO;
import com.cleancoders.hackacode.security.application.dto.operation.OperationDTO;
import com.cleancoders.hackacode.security.application.dto.role.RoleDTO;
import com.cleancoders.hackacode.security.domain.GrantedPermission;
import com.cleancoders.hackacode.security.domain.Operation;
import com.cleancoders.hackacode.security.domain.Role;

public interface SecurityConfigPersistence {
    Role addRole(RoleDTO role);
    
    Module createModule(ModuleDTO moduleDTO);

    Operation createOperation(OperationDTO operation);

    GrantedPermission createGrantedPermission(GrantedPermissionDTO grantedPermission);

    Role createRole(RoleDTO role);
}
