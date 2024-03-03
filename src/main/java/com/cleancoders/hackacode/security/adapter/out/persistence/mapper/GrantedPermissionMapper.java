package com.cleancoders.hackacode.security.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.security.adapter.out.persistence.entity.GrantedPermissionEntity;
import com.cleancoders.hackacode.security.domain.GrantedPermission;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceMapper
@Qualifier("grantedPermissionMapper")
public class GrantedPermissionMapper implements Mapper<GrantedPermission, GrantedPermissionEntity> {
    @Override
    public GrantedPermission entityToDomain(GrantedPermissionEntity grantedPermissionEntity) {
        return null;
    }

    @Override
    public GrantedPermissionEntity domainToEntity(GrantedPermission grantedPermission) {
        return null;
    }
}
