package com.cleancoders.hackacode.security.application.port.in;

import com.cleancoders.hackacode.security.domain.Module;
import com.cleancoders.hackacode.security.domain.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SecuritySelector {
    List<Role> allRoles();

    Page<Module> allModules(Pageable pageable);
}
