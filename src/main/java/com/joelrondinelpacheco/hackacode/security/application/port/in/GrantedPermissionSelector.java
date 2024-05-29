package com.joelrondinelpacheco.hackacode.security.application.port.in;

import com.joelrondinelpacheco.hackacode.security.domain.GrantedPermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GrantedPermissionSelector {
    Page<GrantedPermission> getPage(Pageable pageable);
}
