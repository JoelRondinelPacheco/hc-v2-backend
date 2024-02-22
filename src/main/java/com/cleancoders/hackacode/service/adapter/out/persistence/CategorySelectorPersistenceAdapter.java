package com.cleancoders.hackacode.service.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.service.adapter.out.persistence.mapper.CategoryMapper;
import com.cleancoders.hackacode.service.adapter.out.persistence.repository.CategoryMySQLRepository;
import com.cleancoders.hackacode.service.application.port.out.CategorySelectorPort;
import com.cleancoders.hackacode.service.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@PersistenceAdapter
public class CategorySelectorPersistenceAdapter implements CategorySelectorPort {

    @Autowired
    private CategoryMySQLRepository categoryMySQLRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Page<Category> getPage(Pageable pageable) {
        return this.categoryMySQLRepository.findAll(pageable).map(this.categoryMapper::entityToDomain);
    }
}
