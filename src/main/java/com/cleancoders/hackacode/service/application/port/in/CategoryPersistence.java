package com.cleancoders.hackacode.service.application.port.in;

import com.cleancoders.hackacode.service.application.dto.NewCategoryDTO;
import com.cleancoders.hackacode.service.application.dto.NewCategoryDTOb;
import com.cleancoders.hackacode.service.domain.Category;

import java.util.List;

public interface CategoryPersistence {
    Category newCategory(NewCategoryDTO categoryDTO);
}
