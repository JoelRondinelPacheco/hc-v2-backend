package com.joelrondinelpacheco.hackacode.service.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.entity.CategoryEntity;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.entity.ServiceEntity;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.mapper.ServiceMapper;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.repository.CategoryMySQLRepository;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.repository.ServiceMySQLRepository;
import com.joelrondinelpacheco.hackacode.service.application.dto.NewServiceDTO;
import com.joelrondinelpacheco.hackacode.service.application.port.out.ServicePersistencePort;
import com.joelrondinelpacheco.hackacode.service.domain.ServiceData;

import java.util.Optional;

@PersistenceAdapter
public class ServicePersistenceAdapter implements ServicePersistencePort {

    private final ServiceMySQLRepository serviceRepository;
    private final CategoryMySQLRepository categoryRepository;
    private final ServiceMapper mapper;

    public ServicePersistenceAdapter(ServiceMySQLRepository serviceRepository, CategoryMySQLRepository categoryRepository, ServiceMapper mapper) {
        this.serviceRepository = serviceRepository;
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public ServiceData newService(NewServiceDTO serviceDTO) {
        CategoryEntity category = this.categoryRepository.findById(serviceDTO.getCategoryId()).orElseThrow();

        ServiceEntity serviceEntity = this.mapper.dtoToEntity(serviceDTO);

        serviceEntity.setCategory(category);

        return this.mapper.entityToDomain(this.serviceRepository.save(serviceEntity));
    }

    @Override
    public ServiceData update(ServiceData serviceBase) {
        CategoryEntity category = this.categoryRepository.findById(serviceBase.getCategory().getId()).orElseThrow();

        ServiceEntity serviceEntity = this.serviceRepository.findById(serviceBase.getId()).orElseThrow();
            serviceEntity.setName(serviceBase.getName());
            serviceEntity.setDescription(serviceBase.getDescription());
            serviceEntity.setPrice(serviceBase.getPrice());
            serviceEntity.setCategory(category);
            serviceEntity = this.serviceRepository.save(serviceEntity);
            return this.mapper.entityToDomain(serviceEntity);

    }
}
