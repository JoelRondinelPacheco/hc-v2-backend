package com.joelrondinelpacheco.hackacode.service.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.common.domain.EntityAlreadyExistsException;
import com.joelrondinelpacheco.hackacode.common.domain.PersistenceException;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.entity.CategoryEntity;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.mapper.CategoryMapper;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.repository.CategoryMySQLRepository;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.repository.ServiceMySQLRepository;
import com.joelrondinelpacheco.hackacode.service.application.port.out.CategoryPersistencePort;
import com.joelrondinelpacheco.hackacode.service.domain.Category;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;

@PersistenceAdapter
public class CategoryPersistenceAdapter implements CategoryPersistencePort {

    @Autowired
    private ServiceMySQLRepository serviceRepository;

    @Autowired
    private CategoryMySQLRepository categoryRepository;
    @Autowired
    private CategoryMapper mapper;

    @Override
    public Category newCategory(Category category) {
        try {
        CategoryEntity categoryEntity = this.mapper.domainToEntity(category);
        return this.mapper.entityToDomain(this.categoryRepository.save(categoryEntity));
        } catch (DuplicateKeyException e) {
            throw new EntityAlreadyExistsException("Category : " + category.getName() + ", already exists.");
        } catch (ConstraintViolationException | DataIntegrityViolationException e) {
            throw new PersistenceException((e.getMessage()));
        }

    }

    @Override
    public Category update(Category category) {
        CategoryEntity categoryUpdated = this.categoryRepository.save(this.mapper.domainToEntityWithId(category));
        return this.mapper.entityToDomain(categoryUpdated);
    }

}
