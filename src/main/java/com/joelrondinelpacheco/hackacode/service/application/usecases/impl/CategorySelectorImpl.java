package com.joelrondinelpacheco.hackacode.service.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.service.application.port.in.CategorySelector;
import com.joelrondinelpacheco.hackacode.service.application.port.out.CategorySelectorPort;
import com.joelrondinelpacheco.hackacode.service.domain.Category;
import com.joelrondinelpacheco.hackacode.service.domain.CategoryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@UseCase
public class CategorySelectorImpl implements CategorySelector {

    @Autowired
    private CategorySelectorPort categorySelectorPort;

    @Override
    public Page<Category> getPage(Pageable pageable) {
        return this.categorySelectorPort.getPage(pageable);
    }

    @Override
    public Page<CategoryInfo> getAllWithServices(Pageable pageable) {
        //TODO IMPL
        //return this.categorySelectorPort.getPage(pageable);
        return null;
    }
}
