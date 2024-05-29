package com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.repository;

import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationMySQLRepository extends JpaRepository<OperationEntity, Long> {
    List<OperationEntity> findByPermitAll(boolean isPublic);
}
