package com.joelrondinelpacheco.hackacode.security.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.mapper.PermissionsRoleMapper;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.repository.RoleMySQLRepository;
import com.joelrondinelpacheco.hackacode.security.application.port.out.RolePersistencePort;
import com.joelrondinelpacheco.hackacode.security.application.port.out.RoleSelectorPort;
import com.joelrondinelpacheco.hackacode.security.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
    public Role getByName(String name) {
        return this.roleMySQLRepository.findByName(name).map(this.mapper::entityToDomainRole).orElseThrow();
    }

    @Override
    public Role findById(Long id) {
        return this.roleMySQLRepository.findById(id).map(this.mapper::entityToDomainRole).orElseThrow();
    }
}
