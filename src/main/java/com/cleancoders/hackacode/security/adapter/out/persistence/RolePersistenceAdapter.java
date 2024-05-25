package com.cleancoders.hackacode.security.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.security.adapter.out.persistence.entity.RoleEntity;
import com.cleancoders.hackacode.security.adapter.out.persistence.mapper.PermissionsRoleMapper;
import com.cleancoders.hackacode.security.adapter.out.persistence.repository.RoleMySQLRepository;
import com.cleancoders.hackacode.security.application.port.out.RolePersistencePort;
import com.cleancoders.hackacode.security.application.port.out.RoleSelectorPort;
import com.cleancoders.hackacode.security.application.port.out.SecuritySelectorPort;
import com.cleancoders.hackacode.security.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@PersistenceAdapter
public class RolePersistenceAdapter implements RoleSelectorPort, RolePersistencePort {

    @Autowired
    private RoleMySQLRepository roleMySQLRepository;
    @Autowired
    private PermissionsRoleMapper mapper;

    @Override
    public Page<Role> getAll(Pageable pageable) {
        return this.roleMySQLRepository.findAll(pageable).map(this.mapper::entityToDomainRole);
    }

    @Override
    public Role findById(Long id) {
        return this.roleMySQLRepository.findById(id).map(this.mapper::entityToDomainRole).orElseThrow();
    }
}
