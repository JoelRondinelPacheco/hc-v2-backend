package com.cleancoders.hackacode.security.application.port.out;

import com.cleancoders.hackacode.security.domain.GrantedPermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GrantedPermissionSelectorPort {
    Page<GrantedPermission> getPage(Pageable pageable);
}
