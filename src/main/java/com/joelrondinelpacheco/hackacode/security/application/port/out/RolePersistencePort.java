package com.joelrondinelpacheco.hackacode.security.application.port.out;

import com.joelrondinelpacheco.hackacode.security.domain.Role;

public interface RolePersistencePort {
    Role findById(Long id);
}
