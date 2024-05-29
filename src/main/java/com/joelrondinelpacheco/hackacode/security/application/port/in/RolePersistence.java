package com.joelrondinelpacheco.hackacode.security.application.port.in;

import com.joelrondinelpacheco.hackacode.security.application.dto.role.RoleDTO;
import com.joelrondinelpacheco.hackacode.security.domain.Role;

public interface RolePersistence {
    Role addRole(RoleDTO body);
}
