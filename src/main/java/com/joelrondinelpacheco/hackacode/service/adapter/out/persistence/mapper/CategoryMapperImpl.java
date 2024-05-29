package com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.mapper;

import com.joelrondinelpacheco.hackacode.common.PersistenceMapper;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.entity.CategoryEntity;
import com.joelrondinelpacheco.hackacode.service.domain.Category;

import java.util.ArrayList;
import java.util.List;

@PersistenceMapper
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category entityToDomain(CategoryEntity entity) {
        Category category = new Category();
        category.setId(entity.getId());
        category.setName(entity.getName());
        category.setDescription(entity.getDescription());
        return category;
    }

    @Override
    public CategoryEntity domainToEntity(Category domain) {
        CategoryEntity categoryEntity = CategoryEntity.builder()
                .name(domain.getName())
                .description(domain.getDescription())
                .build();
        return categoryEntity;
    }

    @Override
    public List<CategoryEntity> domaintToEntityList(List<Category> categories) {
        List<CategoryEntity> categoryEntities = new ArrayList<>();
        for (Category c : categories) {
            categoryEntities.add(this.domainToEntity(c));
        }
        return categoryEntities;
    }

    @Override
    public CategoryEntity domainToEntityWithId(Category category) {
        CategoryEntity cat = this.domainToEntity(category);
        cat.setId(category.getId());
        return cat;
    }
}
