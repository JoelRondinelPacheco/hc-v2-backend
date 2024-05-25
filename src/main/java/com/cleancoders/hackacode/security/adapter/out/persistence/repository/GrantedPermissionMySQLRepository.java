package com.cleancoders.hackacode.security.adapter.out.persistence.repository;

import com.cleancoders.hackacode.security.adapter.out.persistence.entity.GrantedPermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrantedPermissionMySQLRepository extends JpaRepository<GrantedPermissionEntity, Long> {
}
