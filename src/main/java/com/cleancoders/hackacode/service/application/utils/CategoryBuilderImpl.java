package com.cleancoders.hackacode.service.application.utils;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.service.application.dto.CategoryDTOBase;
import com.cleancoders.hackacode.service.application.dto.NewCategoryDTO;
import com.cleancoders.hackacode.service.application.dto.NewCategoryListDTO;
import com.cleancoders.hackacode.service.domain.Category;
import com.cleancoders.hackacode.service.domain.Service;

import java.util.ArrayList;
import java.util.List;

@UseCase
public class CategoryBuilderImpl implements CategoryBuilder{

    @Override
    public Category newCategory(NewCategoryDTO dto) {
        return this.category(dto.getName(), dto.getService());
    }

    @Override
    public List<Category> newCategoryList(NewCategoryListDTO dto) {
        List<Category> categories = new ArrayList<>();
        for (String name : dto.getCategoryNames()) {
            categories.add(this.category(name, dto.getService()));
        }
        return categories;
    }

    private Category category(String name, Service service) {
        Category category = new Category();
        category.setName(name);
        category.setService(service);
        return category;
    }
}
