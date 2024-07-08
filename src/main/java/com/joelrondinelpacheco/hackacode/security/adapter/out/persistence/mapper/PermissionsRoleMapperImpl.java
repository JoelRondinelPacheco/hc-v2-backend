package com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.mapper;

import com.joelrondinelpacheco.hackacode.common.PersistenceMapper;
import com.joelrondinelpacheco.hackacode.common.adapter.Mapper;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity.GrantedPermissionEntity;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity.OperationEntity;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity.RoleEntity;
import com.joelrondinelpacheco.hackacode.security.domain.GrantedPermission;
import com.joelrondinelpacheco.hackacode.security.domain.Operation;
import com.joelrondinelpacheco.hackacode.security.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.stream.Collectors;

@PersistenceMapper
public class PermissionsRoleMapperImpl implements PermissionsRoleMapper{

    @Autowired
    @Qualifier("operationMapper")
    private Mapper<Operation, OperationEntity> operationMapper;

    @Override
    public Role entityToDomainRole(RoleEntity roleEntity) {
        return Role.builder()
                .id(roleEntity.getId())
                .name(roleEntity.getName())
                .permissions(roleEntity.getPermissions().stream().map(this::entityToDomainGrantedPermission).collect(Collectors.toList()))
                .build();
    }

    @Override
    public RoleEntity domainToEntityRole(Role role) {
        return RoleEntity.builder()
                .id(role.getId() != null ? role.getId() : null)
                .name(role.getName())
                .build();
    }

    @Override
    public GrantedPermission entityToDomainGrantedPermission(GrantedPermissionEntity grantedPermissionEntity) {
        return GrantedPermission.builder()
                .id(grantedPermissionEntity.getId())
                .operation(this.operationMapper.entityToDomain(grantedPermissionEntity.getOperation()))
                .build();

    }

    @Override
    public GrantedPermissionEntity domainToEntityGrantedPermission(GrantedPermission grantedPermission) {
        return GrantedPermissionEntity.builder()
                .build();
    }
}
