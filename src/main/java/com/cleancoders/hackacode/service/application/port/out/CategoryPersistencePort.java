package com.cleancoders.hackacode.service.application.port.out;

import com.cleancoders.hackacode.service.domain.Category;

public interface CategoryPersistencePort {
    Category newCategory(Category category);
}
