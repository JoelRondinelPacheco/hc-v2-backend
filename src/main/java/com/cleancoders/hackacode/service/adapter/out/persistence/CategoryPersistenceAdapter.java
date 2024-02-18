package com.cleancoders.hackacode.service.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.service.adapter.out.persistence.entity.CategoryEntity;
import com.cleancoders.hackacode.service.application.port.out.CategoryPersistencePort;
import com.cleancoders.hackacode.service.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

@PersistenceAdapter
public class CategoryPersistenceAdapter implements CategoryPersistencePort {

    @Autowired
    private CategoryMySQLRepository categoryRepository;
    @Autowired
    @Qualifier("categoryMapper")
    private Mapper<Category, CategoryEntity> mapper;

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public List<Category> saveList(List<Category> categories) {
        List<CategoryEntity> categoryEntities = new ArrayList<>();
        for (Category category : categories) {
            categoryEntities.add(this.mapper.domainToEntity(category));
        }
        return this.categoryRepository.saveAll(categoryEntities)
                .stream().map(this.mapper::entityToDomain)
                .toList();
    }
}
