package com.cleancoders.hackacode.service.application.dto;

import com.cleancoders.hackacode.service.domain.Service;

import java.util.List;

public class NewCategoryListDTO extends CategoryDTOBase {
    List<String> categoryNames;

    public List<String> getCategoryNames() {
        return categoryNames;
    }

    public NewCategoryListDTO setCategoryNames(List<String> categoryNames) {
        this.categoryNames = categoryNames;
        return this;
    }
}
