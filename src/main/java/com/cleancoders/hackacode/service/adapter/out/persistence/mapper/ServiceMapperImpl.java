package com.cleancoders.hackacode.service.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.service.adapter.out.persistence.entity.CategoryEntity;
import com.cleancoders.hackacode.service.adapter.out.persistence.entity.ServiceEntity;
import com.cleancoders.hackacode.service.domain.Category;
import com.cleancoders.hackacode.service.domain.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

@PersistenceMapper
@Qualifier("serviceMapper")
public class ServiceMapperImpl implements ServiceMapper {

    @Autowired
    private Mapper<Category, CategoryEntity> categoryMapper;
    @Override
    public Service entityToDomain(ServiceEntity serviceEntity) {
        Service service = Service.builder()
                .name(serviceEntity.getName())
                .description(serviceEntity.getDescription())
                .price(serviceEntity.getPrice())
                .build();
        service.setId(serviceEntity.getId());

        //TODO REFACTOR

        service.setCategory(this.categoryMapper.entityToDomain(serviceEntity.getCategory()));
        return service;
    }

    @Override
    public ServiceEntity domainToEntity(Service service) {
        return ServiceEntity.builder()
                .code(service.getCode())
                .name(service.getName())
                .description(service.getDescription())
                .price(service.getPrice())
                .build();
    }

    @Override
    public List<Service> entityToDomainList(List<ServiceEntity> services) {
        List<Service> serv = new ArrayList<>();

        for (ServiceEntity s : services) {
            serv.add(this.entityToDomain(s));
        }

        return serv;
    }
}
