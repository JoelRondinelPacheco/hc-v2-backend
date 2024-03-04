package com.cleancoders.hackacode.service.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;

import com.cleancoders.hackacode.service.application.dto.EditServiceDTO;
import com.cleancoders.hackacode.service.application.dto.NewServiceDTO;
import com.cleancoders.hackacode.service.application.port.in.ServicePersistence;
import com.cleancoders.hackacode.service.application.port.out.CategoryPersistencePort;
import com.cleancoders.hackacode.service.application.port.out.ServicePersistencePort;
import com.cleancoders.hackacode.service.application.port.out.ServiceSelectorPort;
import com.cleancoders.hackacode.service.application.utils.CategoryUtil;
import com.cleancoders.hackacode.service.application.utils.ServiceBuilder;
import com.cleancoders.hackacode.service.domain.ServiceBase;
import com.cleancoders.hackacode.service.domain.ServiceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@UseCase
public class ServicePersistenceImpl implements ServicePersistence {


    @Autowired
    private ServiceBuilder serviceBuilder;

    @Autowired
    private ServicePersistencePort categoryPersistence;


    @Autowired
    private ServicePersistencePort serviceRepository;
    @Autowired
    private CategoryPersistencePort categoryRepository;
    @Autowired
    private ServiceSelectorPort serviceSelectorPort;


    @Autowired
    private CategoryUtil categoryUtil;

    @Override
    public ServiceData newService(NewServiceDTO serviceDTO) {

        //TODO CHECK NAME
        this.categoryUtil.assertCategoryExistsById(serviceDTO.getCategoryId());

        return this.serviceRepository.newService(serviceDTO);
    }

    @Override
    public ServiceData update(EditServiceDTO serviceDTO) {
        ServiceData service = this.serviceSelectorPort.byId(serviceDTO.getId());
        service.setName(serviceDTO.getName());
        service.setDescription(serviceDTO.getDescription());
        service.setPrice(serviceDTO.getPrice());

        return this.serviceRepository.update(service);
    }

    @Override
    public Page<ServiceData> getByPage(Pageable pageable) {
        return this.serviceSelectorPort.getAll(pageable);
    }

    @Override
    public String deleteService(String serviceId) {
        //TODO DISABLE
        return null;
    }
}
