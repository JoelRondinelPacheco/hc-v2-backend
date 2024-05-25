package com.cleancoders.hackacode.security.application.port.out;

import com.cleancoders.hackacode.security.domain.Role;

public interface RolePersistencePort {
    Role findById(Long id);
}
