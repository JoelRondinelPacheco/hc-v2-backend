package com.cleancoders.hackacode.service.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.service.adapter.out.persistence.entity.CategoryEntity;
import com.cleancoders.hackacode.service.adapter.out.persistence.entity.ServiceEntity;
import com.cleancoders.hackacode.service.domain.Category;
import com.cleancoders.hackacode.service.domain.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceMapper
@Qualifier("serviceMapper")
public class ServiceMapper implements Mapper<Service, ServiceEntity> {

    @Autowired
    private Mapper<Category, CategoryEntity> categoryMapper;
    @Override
    public Service entityToDomain(ServiceEntity serviceEntity) {
        Service service = new Service.ServiceBuilder()
                .name(serviceEntity.getName())
                .description(serviceEntity.getDescription())
                .price(serviceEntity.getPrice())
                .build();
        service.setId(serviceEntity.getId());
        //TODO REFACTOR
        service.setCategories(serviceEntity.getCategories().stream().map(this.categoryMapper::entityToDomain).toList());
        return service;
    }

    @Override
    public ServiceEntity domainToEntity(Service service) {
        return null;
    }
}
