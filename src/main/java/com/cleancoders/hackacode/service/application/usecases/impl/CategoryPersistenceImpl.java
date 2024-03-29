package com.cleancoders.hackacode.service.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.service.application.dto.NewCategoryDTO;
import com.cleancoders.hackacode.service.application.port.in.CategoryPersistence;
import com.cleancoders.hackacode.service.application.port.out.CategoryPersistencePort;
import com.cleancoders.hackacode.service.application.utils.CategoryBuilder;
import com.cleancoders.hackacode.service.application.utils.CategoryUtil;
import com.cleancoders.hackacode.service.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class CategoryPersistenceImpl implements CategoryPersistence {

    @Autowired
    private CategoryPersistencePort categoryPersistencePort;

    @Autowired
    private CategoryBuilder categoryBuilder;
    @Autowired
    private CategoryUtil categoryUtil;

    @Override
    public Category newCategory(NewCategoryDTO categoryDTO) {

        this.categoryUtil.assertCategoryDoesNotExistByName(categoryDTO.getName());

        Category category = this.categoryBuilder.newCategory(categoryDTO);

        return this.categoryPersistencePort.newCategory(category);
    }

}
