package com.cleancoders.hackacode.security.application.port.in;

import com.cleancoders.hackacode.security.domain.Role;

import java.util.List;

public interface SecuritySelector {
    List<Role> allRoles();

}
