package com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.mapper;

import com.joelrondinelpacheco.hackacode.common.PersistenceMapper;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.entity.ServiceEntity;
import com.joelrondinelpacheco.hackacode.service.application.dto.NewServiceDTO;
import com.joelrondinelpacheco.hackacode.service.domain.ServiceData;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@PersistenceMapper
public class ServiceMapperImpl implements ServiceMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ServiceData entityToDomain(ServiceEntity entity) {
        ServiceData service = ServiceData.builder()
                .id(entity.getId())
                .price(entity.getPrice())
                .name(entity.getName())
                .description(entity.getDescription())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getCreatedAt())
                .build();
        service.setCategory(this.categoryMapper.entityToDomain(entity.getCategory()));
        return service;
    }

    @Override
    public ServiceEntity domainToEntity(ServiceData domain) {
        return ServiceEntity.builder()
                .id(domain.getId())
                .price(domain.getPrice())
                .name(domain.getName())
                .description(domain.getDescription())
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
