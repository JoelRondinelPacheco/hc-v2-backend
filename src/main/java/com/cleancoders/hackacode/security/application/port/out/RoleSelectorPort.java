package com.cleancoders.hackacode.security.application.port.out;

import com.cleancoders.hackacode.security.domain.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoleSelectorPort {

    Page<Role> getAll(Pageable pageable);
}
