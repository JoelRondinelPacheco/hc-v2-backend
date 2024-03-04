package com.cleancoders.hackacode.security.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.security.adapter.out.persistence.entity.GrantedPermissionEntity;
import com.cleancoders.hackacode.security.adapter.out.persistence.entity.OperationEntity;
import com.cleancoders.hackacode.security.adapter.out.persistence.entity.RoleEntity;
import com.cleancoders.hackacode.security.domain.GrantedPermission;
import com.cleancoders.hackacode.security.domain.Operation;
import com.cleancoders.hackacode.security.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceMapper
@Qualifier("grantedPermissionMapper")
public class GrantedPermissionMapper implements Mapper<GrantedPermission, GrantedPermissionEntity> {
/*
    @Autowired
    @Qualifier("roleMapper")
    private Mapper<Role, RoleEntity> roleMapper;*/
    @Autowired
    @Qualifier("operationMapper")
    private Mapper<Operation, OperationEntity> operationMapper;

    private RoleMapper roleMapper;

    @Autowired
    public GrantedPermissionMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public GrantedPermission entityToDomain(GrantedPermissionEntity grantedPermissionEntity) {
        return GrantedPermission.builder()
                .id(grantedPermissionEntity.getId())
                .role(this.roleMapper.entityToDomain(grantedPermissionEntity.getRole()))
                .operation(this.operationMapper.entityToDomain(grantedPermissionEntity.getOperation()))
                .build();
    }

    @Override
    public GrantedPermissionEntity domainToEntity(GrantedPermission grantedPermission) {
        return GrantedPermissionEntity.builder()
                .build();
    }
}
