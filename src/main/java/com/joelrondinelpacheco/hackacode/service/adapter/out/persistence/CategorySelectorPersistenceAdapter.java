package com.joelrondinelpacheco.hackacode.service.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.mapper.CategoryMapper;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.repository.CategoryMySQLRepository;
import com.joelrondinelpacheco.hackacode.service.application.port.out.CategorySelectorPort;
import com.joelrondinelpacheco.hackacode.service.domain.Category;
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
