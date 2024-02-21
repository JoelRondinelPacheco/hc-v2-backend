package com.cleancoders.hackacode.service.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.service.application.dto.NewCategoryDTO;
import com.cleancoders.hackacode.service.application.dto.NewCategoryDTOb;
import com.cleancoders.hackacode.service.application.port.in.CategoryPersistence;
import com.cleancoders.hackacode.service.application.port.out.CategoryPersistencePort;
import com.cleancoders.hackacode.service.application.utils.CategoryBuilder;
import com.cleancoders.hackacode.service.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UseCase
public class CategoryPersistenceImpl implements CategoryPersistence {

    @Autowired
    private CategoryPersistencePort categoryPersistencePort;
    @Autowired
    private CategoryBuilder categoryBuilder;


    @Override
    public Category newCategory(NewCategoryDTO categoryDTO) {
        Category category = this.categoryBuilder.newCategory(categoryDTO);
        //TOD CHECK CATEGORIA ALREADY EXISTS
        return this.categoryPersistencePort.save(category);
    }

}
