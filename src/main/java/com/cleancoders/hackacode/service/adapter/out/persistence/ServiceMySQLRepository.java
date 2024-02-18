package com.cleancoders.hackacode.service.adapter.out.persistence;

import com.cleancoders.hackacode.service.adapter.out.persistence.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceMySQLRepository extends JpaRepository<ServiceEntity, Long> {
}
