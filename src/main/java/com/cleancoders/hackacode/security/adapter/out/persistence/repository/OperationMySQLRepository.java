package com.cleancoders.hackacode.security.adapter.out.persistence.repository;

import com.cleancoders.hackacode.security.adapter.out.persistence.entity.OperationEntity;
import com.cleancoders.hackacode.security.domain.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationMySQLRepository extends JpaRepository<OperationEntity, Long> {
    List<OperationEntity> findByPermitAll(boolean isPublic);
}
