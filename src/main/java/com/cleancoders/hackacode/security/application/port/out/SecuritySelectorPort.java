package com.cleancoders.hackacode.security.application.port.out;

import com.cleancoders.hackacode.security.domain.Role;

import java.util.List;

public interface SecuritySelectorPort {
    List<Role> allRoles();

}
