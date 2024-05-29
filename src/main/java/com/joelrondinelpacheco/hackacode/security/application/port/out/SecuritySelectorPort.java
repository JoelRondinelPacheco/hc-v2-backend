package com.joelrondinelpacheco.hackacode.security.application.port.out;

import com.joelrondinelpacheco.hackacode.security.domain.Role;

import java.util.List;

public interface SecuritySelectorPort {
    List<Role> allRoles();

}
