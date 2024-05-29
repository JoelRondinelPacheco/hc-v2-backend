package com.joelrondinelpacheco.hackacode.service.application.utils;

import com.joelrondinelpacheco.hackacode.service.application.dto.NewCategoryDTO;
import com.joelrondinelpacheco.hackacode.service.domain.Category;

import java.util.List;

public interface CategoryBuilder {

    Category newCategory(NewCategoryDTO dto);
    List<Category> newServiceCategoryList(NewCategoryDTO service);

}
