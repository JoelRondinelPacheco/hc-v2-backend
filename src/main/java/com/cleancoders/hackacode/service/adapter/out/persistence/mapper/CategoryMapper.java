package com.cleancoders.hackacode.service.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.service.adapter.out.persistence.entity.CategoryEntity;
import com.cleancoders.hackacode.service.domain.Category;

import java.util.List;

public interface CategoryMapper extends Mapper<Category, CategoryEntity> {
    List<CategoryEntity> domaintToEntityList(List<Category> categories);
    CategoryEntity domainToEntityWithId(Category category);
}
