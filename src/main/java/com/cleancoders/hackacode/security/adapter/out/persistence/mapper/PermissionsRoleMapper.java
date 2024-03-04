package com.cleancoders.hackacode.security.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.security.adapter.out.persistence.entity.GrantedPermissionEntity;
import com.cleancoders.hackacode.security.adapter.out.persistence.entity.RoleEntity;
import com.cleancoders.hackacode.security.domain.GrantedPermission;
import com.cleancoders.hackacode.security.domain.Role;

public interface PermissionsRoleMapper {
    Role entityToDomainRole(RoleEntity roleEntity);
    RoleEntity domainToEntityRole(Role role);

    GrantedPermission entityToDomainGrantedPermission(GrantedPermissionEntity grantedPermissionEntity);
    GrantedPermissionEntity domainToEntityGrantedPermission(GrantedPermission grantedPermission);
}
