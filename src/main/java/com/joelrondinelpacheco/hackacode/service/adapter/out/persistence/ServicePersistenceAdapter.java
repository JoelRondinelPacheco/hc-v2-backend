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
import org.springframework.beans.factory.annotation.Autowired;

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
