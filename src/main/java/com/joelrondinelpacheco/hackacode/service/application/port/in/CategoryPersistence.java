package com.joelrondinelpacheco.hackacode.service.application.port.in;

import com.joelrondinelpacheco.hackacode.service.application.dto.NewCategoryDTO;
import com.joelrondinelpacheco.hackacode.service.domain.Category;

public interface CategoryPersistence {
    Category newCategory(NewCategoryDTO categoryDTO);
    Category update(Category category);
}
