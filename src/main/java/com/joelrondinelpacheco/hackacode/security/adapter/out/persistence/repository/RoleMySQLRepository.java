package com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.repository;

import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleMySQLRepository extends JpaRepository<RoleEntity, Long> {
}
