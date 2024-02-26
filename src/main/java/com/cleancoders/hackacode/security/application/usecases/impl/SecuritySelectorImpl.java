package com.cleancoders.hackacode.security.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.security.application.port.in.SecuritySelector;
import com.cleancoders.hackacode.security.application.port.out.SecuritySelectorPort;
import com.cleancoders.hackacode.security.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UseCase
public class SecuritySelectorImpl implements SecuritySelector {

    @Autowired
    private SecuritySelectorPort securitySelectorPort;


    @Override
    public List<Role> allRoles() {
        return this.securitySelectorPort.allRoles();
    }


}
