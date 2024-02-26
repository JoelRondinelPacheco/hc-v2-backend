package com.cleancoders.hackacode.security.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.security.adapter.out.persistence.entity.RoleEntity;
import com.cleancoders.hackacode.security.domain.Role;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceMapper
@Qualifier("roleMapper")
public class RoleMapper implements Mapper<Role, RoleEntity> {
    @Override
    public Role entityToDomain(RoleEntity roleEntity) {
        Role role = new Role();
        role.setId(roleEntity.getId());
        role.setName(roleEntity.getName());
        return role;
    }

    @Override
    public RoleEntity domainToEntity(Role role) {
        return null;
    }
}
