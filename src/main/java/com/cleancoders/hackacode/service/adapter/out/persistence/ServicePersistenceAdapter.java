package com.cleancoders.hackacode.service.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.service.adapter.out.persistence.entity.CategoryEntity;
import com.cleancoders.hackacode.service.adapter.out.persistence.entity.ServiceEntity;
import com.cleancoders.hackacode.service.adapter.out.persistence.repository.CategoryMySQLRepository;
import com.cleancoders.hackacode.service.adapter.out.persistence.repository.ServiceMySQLRepository;
import com.cleancoders.hackacode.service.application.port.out.ServicePersistencePort;
import com.cleancoders.hackacode.service.domain.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceAdapter
public class ServicePersistenceAdapter implements ServicePersistencePort {

    @Autowired
    private ServiceMySQLRepository serviceRepository;
    @Autowired
    private CategoryMySQLRepository categoryRepository;
    @Autowired
    @Qualifier("serviceMapper")
    private Mapper<Service, ServiceEntity> mapper;

    @Override
    public Service save(Service service) {

        CategoryEntity category = this.categoryRepository.findById(service.getCategoryId()).orElseThrow();

        ServiceEntity serviceEntity = this.mapper.domainToEntity(service);

        serviceEntity.setCategory(category);

        return this.mapper.entityToDomain(this.serviceRepository.save(serviceEntity));
    }

    @Override
    public Service update(Service service) {
        return null;
    }
}
