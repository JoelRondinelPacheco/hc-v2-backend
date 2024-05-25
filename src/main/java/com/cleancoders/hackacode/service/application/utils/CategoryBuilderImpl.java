package com.cleancoders.hackacode.service.application.utils;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.service.application.dto.NewCategoryDTOb;
import com.cleancoders.hackacode.service.application.dto.NewCategoryListDTO;
import com.cleancoders.hackacode.service.application.dto.NewCategoryDTO;
import com.cleancoders.hackacode.service.domain.Category;

import java.util.ArrayList;
import java.util.List;

@UseCase
public class CategoryBuilderImpl implements CategoryBuilder{

    @Override
    public Category newCategory(NewCategoryDTO dto) {
        return this.category(dto.getName(), dto.getDescription());
    }

    @Override
    public List<Category> newServiceCategoryList(NewCategoryDTO service) {
        return null;
    }

    private Category category(String name, String description) {
        return Category.builder()
                .name(name)
                .description(description)
                .build();
    }
}
