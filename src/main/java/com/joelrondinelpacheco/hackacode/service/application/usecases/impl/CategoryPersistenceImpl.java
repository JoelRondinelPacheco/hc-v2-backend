package com.joelrondinelpacheco.hackacode.service.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.service.application.dto.NewCategoryDTO;
import com.joelrondinelpacheco.hackacode.service.application.port.in.CategoryPersistence;
import com.joelrondinelpacheco.hackacode.service.application.port.out.CategoryPersistencePort;
import com.joelrondinelpacheco.hackacode.service.application.utils.CategoryBuilder;
import com.joelrondinelpacheco.hackacode.service.application.utils.CategoryUtil;
import com.joelrondinelpacheco.hackacode.service.domain.Category;
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

    @Override
    public Category update(Category category) {
        //assert category exists
        return this.categoryPersistencePort.update(category);
    }

}
