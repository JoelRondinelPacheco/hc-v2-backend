package com.cleancoders.hackacode.service.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.service.adapter.out.persistence.entity.CategoryEntity;
import com.cleancoders.hackacode.service.adapter.out.persistence.entity.ServiceEntity;
import com.cleancoders.hackacode.service.adapter.out.persistence.mapper.ServiceMapper;
import com.cleancoders.hackacode.service.adapter.out.persistence.repository.CategoryMySQLRepository;
import com.cleancoders.hackacode.service.adapter.out.persistence.repository.ServiceMySQLRepository;
import com.cleancoders.hackacode.service.application.dto.NewServiceDTO;
import com.cleancoders.hackacode.service.application.port.out.ServicePersistencePort;
import com.cleancoders.hackacode.service.domain.ServiceBase;
import com.cleancoders.hackacode.service.domain.ServiceData;
import com.cleancoders.hackacode.service.domain.ServiceReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceAdapter
public class ServicePersistenceAdapter implements ServicePersistencePort {

    @Autowired
    private ServiceMySQLRepository serviceRepository;
    @Autowired
    private CategoryMySQLRepository categoryRepository;
    @Autowired
    private ServiceMapper mapper;

    @Override
    public ServiceData newService(NewServiceDTO serviceDTO) {
        CategoryEntity category = this.categoryRepository.findById(serviceDTO.getCategoryId()).orElseThrow();

        ServiceEntity serviceEntity = this.mapper.dtoToEntity(serviceDTO);

        serviceEntity.setCategory(category);

        return this.mapper.entityToDomain(this.serviceRepository.save(serviceEntity));
    }

    @Override
    public ServiceData update(ServiceData serviceBase) {
        return null;
    }
}
