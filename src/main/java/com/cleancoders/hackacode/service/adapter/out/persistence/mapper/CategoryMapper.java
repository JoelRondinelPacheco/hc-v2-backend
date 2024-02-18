package com.cleancoders.hackacode.service.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.service.adapter.out.persistence.entity.CategoryEntity;
import com.cleancoders.hackacode.service.domain.Category;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceMapper
@Qualifier("categoryMapper")
public class CategoryMapper implements Mapper<Category, CategoryEntity> {

    @Override
    public Category entityToDomain(CategoryEntity categoryEntity) {
        Category category = new Category();
        category.setName(categoryEntity.getName());
        return category;
    }

    @Override
    public CategoryEntity domainToEntity(Category category) {
        return null;
    }
}
