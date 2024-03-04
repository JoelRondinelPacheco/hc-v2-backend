package com.cleancoders.hackacode.security.adapter.out.persistence.repository;

import com.cleancoders.hackacode.security.adapter.out.persistence.entity.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationMySQLRepository extends JpaRepository<OperationEntity, Long> {
}
