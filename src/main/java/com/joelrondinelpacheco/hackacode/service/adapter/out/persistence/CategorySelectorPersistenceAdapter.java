package com.joelrondinelpacheco.hackacode.service.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.common.domain.EntityNotFoundException;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.entity.CategoryEntity;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.mapper.CategoryMapper;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.repository.CategoryMySQLRepository;
import com.joelrondinelpacheco.hackacode.service.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@PersistenceAdapter
public class CategorySelectorPersistenceAdapter implements CategorySelectorAdapter {

    private final CategoryMySQLRepository categoryMySQLRepository;
    private final CategoryMapper categoryMapper;

    public CategorySelectorPersistenceAdapter(CategoryMySQLRepository categoryMySQLRepository, CategoryMapper categoryMapper) {
        this.categoryMySQLRepository = categoryMySQLRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Page<Category> getPage(Pageable pageable) {
        return this.categoryMySQLRepository.findAll(pageable).map(this.categoryMapper::entityToDomain);
    }

    @Override
    public Category getById(Long categoryId) {
        return this.categoryMapper.entityToDomain(this.getCategoryEntityById(categoryId));
    }

    @Override
    public CategoryEntity getCategoryEntityById(Long id) {
        return this.categoryMySQLRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Category with ID: " + id + ", not found.")
        );
    }
}
