package com.cleancoders.hackacode.service.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.service.adapter.out.persistence.entity.CategoryEntity;
import com.cleancoders.hackacode.service.adapter.out.persistence.entity.ServiceEntity;
import com.cleancoders.hackacode.service.application.dto.NewServiceDTO;
import com.cleancoders.hackacode.service.domain.*;
import com.cleancoders.hackacode.service.domain.ServiceBase;
import com.cleancoders.hackacode.service.domain.ServiceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

@PersistenceMapper
public class ServiceMapperImpl implements ServiceMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ServiceData entityToDomain(ServiceEntity entity) {
        ServiceData service = ServiceData.builder()
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getCreatedAt())
                .build();
        service.setId(entity.getId());

        //TODO REFACTOR

        service.setCategory(this.categoryMapper.entityToDomain(entity.getCategory()));
        return service;
    }

    @Override
    public ServiceEntity domainToEntity(ServiceData domain) {
        return ServiceEntity.builder()
                .name(domain.getName())
                .description(domain.getDescription())
                .price(domain.getPrice())
                .build();
    }

    @Override
    public List<ServiceData> entityToDomainList(List<ServiceEntity> services) {
        List<ServiceData> serv = new ArrayList<>();

        for (ServiceEntity s : services) {
            serv.add(this.entityToDomain(s));
        }

        return serv;
    }

    @Override
    public ServiceEntity dtoToEntity(NewServiceDTO serviceDTO) {
        return ServiceEntity.builder()
                .name(serviceDTO.getName())
                .description(serviceDTO.getDescription())
                .price(serviceDTO.getPrice())
                .build();
    }
}
