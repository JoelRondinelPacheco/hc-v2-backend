package com.cleancoders.hackacode.service.application.utils;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.service.application.port.out.CategoryUtilPort;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class CategoryUtilImpl implements CategoryUtil{

    @Autowired
    private CategoryUtilPort categoryUtilPort;

    @Override
    public void assertCategoryDoesNotExistByName(String name) {
        if (this.categoryUtilPort.existsByName(name)) {
            throw new RuntimeException("TODO");
        }
    }

    @Override
    public void assertCategoryExistsById(Long id) {
        if (!this.categoryUtilPort.existsById(id)) {
            throw new RuntimeException("todo");
        }
    }
}
