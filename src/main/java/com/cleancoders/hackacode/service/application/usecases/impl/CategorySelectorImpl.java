package com.cleancoders.hackacode.service.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.service.application.port.in.CategorySelector;
import com.cleancoders.hackacode.service.application.port.out.CategorySelectorPort;
import com.cleancoders.hackacode.service.domain.Category;
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
}
