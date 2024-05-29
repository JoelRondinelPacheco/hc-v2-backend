package com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.repository;

import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryMySQLRepository extends JpaRepository<CategoryEntity, Long> {
    boolean existsByName(String name);
}
