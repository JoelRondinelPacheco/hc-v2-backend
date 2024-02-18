package com.cleancoders.hackacode.service.application.port.out;

import com.cleancoders.hackacode.service.domain.Category;

import java.util.List;

public interface CategoryPersistencePort {
    Category save(Category category);
    List<Category> saveList(List<Category> categories);
}
