package com.joelrondinelpacheco.hackacode.service.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.entity.CategoryEntity;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.mapper.CategoryMapper;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.repository.CategoryMySQLRepository;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.repository.ServiceMySQLRepository;
import com.joelrondinelpacheco.hackacode.service.application.port.out.CategoryPersistencePort;
import com.joelrondinelpacheco.hackacode.service.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;

@PersistenceAdapter
public class CategoryPersistenceAdapter implements CategoryPersistencePort {

    @Autowired
    private ServiceMySQLRepository serviceRepository;

    @Autowired
    private CategoryMySQLRepository categoryRepository;
    @Autowired
    private CategoryMapper mapper;

    @Override
    public Category newCategory(Category category) {
        System.out.println("En category");
        try {
        CategoryEntity categoryEntity = this.mapper.domainToEntity(category);
        return this.mapper.entityToDomain(this.categoryRepository.save(categoryEntity));
        } catch (RuntimeException ex) {
            System.out.println("Al guardar ");
            System.out.println(ex);
            throw ex;
        }

    }

    @Override
    public Category update(Category category) {
        CategoryEntity categoryUpdated = this.categoryRepository.save(this.mapper.domainToEntityWithId(category));
        return this.mapper.entityToDomain(categoryUpdated);
    }

}
