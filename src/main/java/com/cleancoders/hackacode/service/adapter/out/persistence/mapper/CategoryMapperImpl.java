package com.cleancoders.hackacode.service.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.service.adapter.out.persistence.entity.CategoryEntity;
import com.cleancoders.hackacode.service.domain.Category;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

@PersistenceMapper
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category entityToDomain(CategoryEntity categoryEntity) {
        Category category = new Category();
        category.setId(categoryEntity.getId());
        category.setName(categoryEntity.getName());
        category.setDescription(categoryEntity.getDescription());
        return category;
    }

    @Override
    public CategoryEntity domainToEntity(Category category) {
        CategoryEntity categoryEntity = CategoryEntity.builder()
                .name(category.getName())
                .description(category.getDescription())
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
}
