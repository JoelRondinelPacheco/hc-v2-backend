package com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.mapper;

import com.joelrondinelpacheco.hackacode.common.adapter.Mapper;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.entity.CategoryEntity;
import com.joelrondinelpacheco.hackacode.service.domain.Category;

import java.util.List;

public interface CategoryMapper extends Mapper<Category, CategoryEntity> {
    List<CategoryEntity> domaintToEntityList(List<Category> categories);
    CategoryEntity domainToEntityWithId(Category category);
}
