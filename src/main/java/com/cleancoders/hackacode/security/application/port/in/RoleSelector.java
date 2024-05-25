package com.cleancoders.hackacode.security.application.port.in;

import com.cleancoders.hackacode.security.domain.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoleSelector {
    Page<Role> getPage(Pageable pageable);
}
