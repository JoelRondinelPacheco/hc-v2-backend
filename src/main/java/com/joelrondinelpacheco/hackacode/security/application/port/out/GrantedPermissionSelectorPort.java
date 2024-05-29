package com.joelrondinelpacheco.hackacode.security.application.port.out;

import com.joelrondinelpacheco.hackacode.security.domain.GrantedPermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GrantedPermissionSelectorPort {
    Page<GrantedPermission> getPage(Pageable pageable);
}
