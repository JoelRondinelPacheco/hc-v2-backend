package com.cleancoders.hackacode.security.application.port.in;

import com.cleancoders.hackacode.security.application.dto.role.RoleDTO;
import com.cleancoders.hackacode.security.domain.Role;

public interface RolePersistence {
    Role addRole(RoleDTO body);
}
