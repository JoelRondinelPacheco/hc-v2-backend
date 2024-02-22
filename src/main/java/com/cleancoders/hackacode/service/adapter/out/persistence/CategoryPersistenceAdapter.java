package com.cleancoders.hackacode.service.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.service.adapter.out.persistence.entity.CategoryEntity;
import com.cleancoders.hackacode.service.adapter.out.persistence.repository.CategoryMySQLRepository;
import com.cleancoders.hackacode.service.adapter.out.persistence.repository.ServiceMySQLRepository;
import com.cleancoders.hackacode.service.application.port.out.CategoryPersistencePort;
import com.cleancoders.hackacode.service.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceAdapter
public class CategoryPersistenceAdapter implements CategoryPersistencePort {

    @Autowired
    private ServiceMySQLRepository serviceRepository;

    @Autowired
    private CategoryMySQLRepository categoryRepository;
    @Autowired
    @Qualifier("categoryMapper")
    private Mapper<Category, CategoryEntity> mapper;

    @Override
    public Category save(Category category) {
        CategoryEntity categoryEntity = this.mapper.domainToEntity(category);
        return this.mapper.entityToDomain(this.categoryRepository.save(categoryEntity));
    }

}
