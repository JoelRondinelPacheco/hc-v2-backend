package com.cleancoders.hackacode.security.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.security.adapter.out.persistence.entity.GrantedPermissionEntity;
import com.cleancoders.hackacode.security.adapter.out.persistence.entity.RoleEntity;
import com.cleancoders.hackacode.security.domain.GrantedPermission;
import com.cleancoders.hackacode.security.domain.Role;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.stream.Collectors;

@PersistenceMapper
@Qualifier("roleMapper")
public class RoleMapper implements Mapper<Role, RoleEntity> {
/*
    @Autowired
    @Qualifier("grantedPermissionMapper")
    private Mapper<GrantedPermission, GrantedPermissionEntity> grantedPermissionMapper;*/

    private GrantedPermissionMapper grantedPermissionMapper;
    @Autowired
    public RoleMapper(GrantedPermissionMapper grantedPermissionMapper) {
        this.grantedPermissionMapper = grantedPermissionMapper;
    }

    @Override
    public Role entityToDomain(RoleEntity entity) {
        return Role.builder()
                .id(entity.getId())
                .name(entity.getName())
                .permissions(entity.getPermissions().stream().map(this.grantedPermissionMapper::entityToDomain).collect(Collectors.toList()))
                .build();
    }

    @Override
    public RoleEntity domainToEntity(Role domain) {
        return RoleEntity.builder()
                .name(domain.getName())
                .build();
    }
}
