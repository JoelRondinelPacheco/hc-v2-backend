package com.joelrondinelpacheco.hackacode.security.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.mapper.PermissionsRoleMapper;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.repository.GrantedPermissionMySQLRepository;
import com.joelrondinelpacheco.hackacode.security.application.dto.grantedpermission.GrantedPermissionDTO;
import com.joelrondinelpacheco.hackacode.security.application.port.out.GrantedPermissionPersistencePort;
import com.joelrondinelpacheco.hackacode.security.application.port.out.GrantedPermissionSelectorPort;
import com.joelrondinelpacheco.hackacode.security.domain.GrantedPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@PersistenceAdapter
public class GrantedPermissionPersistenceAdapter implements GrantedPermissionPersistencePort, GrantedPermissionSelectorPort {

    @Autowired
    private GrantedPermissionMySQLRepository grantedPermissionMySQLRepository;
    @Autowired
    private PermissionsRoleMapper mapper;

    @Override
    public GrantedPermission addGrantedPermission(GrantedPermissionDTO grantedPermission) {
        return null;
    }

    @Override
    public Page<GrantedPermission> getPage(Pageable pageable) {
        return null;
    }
}
