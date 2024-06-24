package com.joelrondinelpacheco.hackacode.service.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.common.application.validators.ObjectsValidator;
import com.joelrondinelpacheco.hackacode.service.application.dto.NewCategoryDTO;
import com.joelrondinelpacheco.hackacode.service.application.port.in.CategoryPersistence;
import com.joelrondinelpacheco.hackacode.service.application.port.out.CategoryPersistencePort;
import com.joelrondinelpacheco.hackacode.service.application.utils.CategoryBuilder;
import com.joelrondinelpacheco.hackacode.service.application.utils.CategoryUtil;
import com.joelrondinelpacheco.hackacode.service.domain.Category;

@UseCase
public class CategoryPersistenceImpl implements CategoryPersistence {


    private final CategoryPersistencePort categoryPersistencePort;
    private final CategoryBuilder categoryBuilder;
    private final CategoryUtil categoryUtil;
    private final ObjectsValidator<NewCategoryDTO> validator;

    public CategoryPersistenceImpl(CategoryPersistencePort categoryPersistencePort, CategoryBuilder categoryBuilder, CategoryUtil categoryUtil, ObjectsValidator<NewCategoryDTO> validator) {
        this.categoryPersistencePort = categoryPersistencePort;
        this.categoryBuilder = categoryBuilder;
        this.categoryUtil = categoryUtil;
        this.validator = validator;
    }

    @Override
    public Category newCategory(NewCategoryDTO categoryDTO) {
        this.validator.validate(categoryDTO);
        this.categoryUtil.assertCategoryDoesNotExistByName(categoryDTO.getName());

        Category category = this.categoryBuilder.newCategory(categoryDTO);

        return this.categoryPersistencePort.newCategory(category);
    }

    @Override
    public Category update(Category category) {
        //assert category exists
        return this.categoryPersistencePort.update(category);
    }

}
