package com.joelrondinelpacheco.hackacode.service.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.repository.CategoryMySQLRepository;
import com.joelrondinelpacheco.hackacode.service.application.port.out.CategoryUtilPort;
import org.springframework.beans.factory.annotation.Autowired;

@PersistenceAdapter
public class CategoryUtilPersistenceAdapter implements CategoryUtilPort {

    @Autowired
    private CategoryMySQLRepository categoryMySQLRepository;

    @Override
    public boolean existsByName(String name) {
        return this.categoryMySQLRepository.existsByName(name);
    }

    @Override
    public boolean existsById(Long id) {
        return this.categoryMySQLRepository.existsById(id);
    }
}
