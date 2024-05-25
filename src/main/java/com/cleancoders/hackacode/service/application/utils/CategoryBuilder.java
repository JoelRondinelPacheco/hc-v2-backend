package com.cleancoders.hackacode.service.application.utils;

import com.cleancoders.hackacode.service.application.dto.NewCategoryListDTO;
import com.cleancoders.hackacode.service.application.dto.NewCategoryDTO;
import com.cleancoders.hackacode.service.domain.Category;

import java.util.List;

public interface CategoryBuilder {

    Category newCategory(NewCategoryDTO dto);
    List<Category> newServiceCategoryList(NewCategoryDTO service);

}
