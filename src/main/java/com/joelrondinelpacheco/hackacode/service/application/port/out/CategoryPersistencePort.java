package com.joelrondinelpacheco.hackacode.service.application.port.out;

import com.joelrondinelpacheco.hackacode.service.domain.Category;

public interface CategoryPersistencePort {
    Category newCategory(Category category);
    Category update(Category category);
}
