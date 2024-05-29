package com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.repository;

import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleMySQLRepository extends JpaRepository<ModuleEntity, Long> {
}
