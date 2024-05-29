package com.joelrondinelpacheco.hackacode.security.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.security.application.port.in.GrantedPermissionSelector;
import com.joelrondinelpacheco.hackacode.security.application.port.out.GrantedPermissionSelectorPort;
import com.joelrondinelpacheco.hackacode.security.domain.GrantedPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@UseCase
public class GrantedPermissionSelectorImpl implements GrantedPermissionSelector {

    @Autowired
    private GrantedPermissionSelectorPort grantedPermissionSelectorPort;

    @Override
    public Page<GrantedPermission> getPage(Pageable pageable) {
        return null;
    }
}
