package com.cleancoders.hackacode.service.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;

import com.cleancoders.hackacode.service.application.dto.NewServiceDTO;
import com.cleancoders.hackacode.service.application.port.in.ServicePersistence;
import com.cleancoders.hackacode.service.application.port.out.CategoryPersistencePort;
import com.cleancoders.hackacode.service.application.port.out.ServicePersistencePort;
import com.cleancoders.hackacode.service.application.utils.CategoryUtil;
import com.cleancoders.hackacode.service.application.utils.ServiceBuilder;
import com.cleancoders.hackacode.service.domain.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    private CategoryUtil categoryUtil;

    @Override
    public Service newService(NewServiceDTO serviceDTO) {

        this.categoryUtil.assertCategoryExistsById(serviceDTO.getCategoryId());

        Service service = this.serviceRepository.save(this.serviceBuilder.fromDTO(serviceDTO));

        return this.serviceRepository.save(service);
    }

    @Override
    public Service update(Service service) {
        return null;
    }
}
