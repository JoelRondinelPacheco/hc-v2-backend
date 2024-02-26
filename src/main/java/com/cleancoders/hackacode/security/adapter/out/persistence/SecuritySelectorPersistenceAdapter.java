package com.cleancoders.hackacode.security.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.security.adapter.out.persistence.entity.RoleEntity;
import com.cleancoders.hackacode.security.adapter.out.persistence.repository.RoleMySQLRepository;
import com.cleancoders.hackacode.security.application.port.out.SecuritySelectorPort;
import com.cleancoders.hackacode.security.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@PersistenceAdapter
public class SecuritySelectorPersistenceAdapter implements SecuritySelectorPort {

    @Autowired
    private RoleMySQLRepository roleMySQLRepository;
    @Autowired
    @Qualifier("roleMapper")
    private Mapper<Role, RoleEntity> mapper;

    @Override
    public List<Role> allRoles() {
        return this.roleMySQLRepository.findAll().stream().map(this.mapper::entityToDomain).toList();
    }
}
