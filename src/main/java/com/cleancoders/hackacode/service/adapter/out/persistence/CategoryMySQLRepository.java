package com.cleancoders.hackacode.service.adapter.out.persistence;

import com.cleancoders.hackacode.service.adapter.out.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryMySQLRepository extends JpaRepository<CategoryEntity, Long> {
}
