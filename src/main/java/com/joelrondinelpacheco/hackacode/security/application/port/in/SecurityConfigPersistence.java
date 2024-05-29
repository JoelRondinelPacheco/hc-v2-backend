package com.joelrondinelpacheco.hackacode.security.application.port.in;

import com.joelrondinelpacheco.hackacode.security.application.dto.grantedpermission.GrantedPermissionDTO;
import com.joelrondinelpacheco.hackacode.security.application.dto.module.ModuleDTO;
import com.joelrondinelpacheco.hackacode.security.application.dto.operation.OperationDTO;
import com.joelrondinelpacheco.hackacode.security.application.dto.role.RoleDTO;
import com.joelrondinelpacheco.hackacode.security.domain.GrantedPermission;
import com.joelrondinelpacheco.hackacode.security.domain.Operation;
import com.joelrondinelpacheco.hackacode.security.domain.Role;

public interface SecurityConfigPersistence {
    Role addRole(RoleDTO role);
    
    Module createModule(ModuleDTO moduleDTO);

    Operation createOperation(OperationDTO operation);

    GrantedPermission createGrantedPermission(GrantedPermissionDTO grantedPermission);

    Role createRole(RoleDTO role);
}
