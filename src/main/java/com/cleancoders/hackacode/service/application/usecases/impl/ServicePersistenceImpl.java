package com.cleancoders.hackacode.service.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.service.application.dto.NewCategoryListDTO;
import com.cleancoders.hackacode.service.application.dto.NewServiceDTO;
import com.cleancoders.hackacode.service.application.port.in.ServicePersistence;
import com.cleancoders.hackacode.service.application.port.out.CategoryPersistencePort;
import com.cleancoders.hackacode.service.application.port.out.ServicePersistencePort;
import com.cleancoders.hackacode.service.application.utils.CategoryBuilder;
import com.cleancoders.hackacode.service.application.utils.ServiceBuilder;
import com.cleancoders.hackacode.service.domain.Category;
import com.cleancoders.hackacode.service.domain.Service;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UseCase
public class ServicePersistenceImpl implements ServicePersistence {


    @Autowired
    private ServiceBuilder serviceBuilder;
    @Autowired
    private CategoryBuilder categoryBuilder;

    @Autowired
    private ServicePersistencePort serviceRepository;
    @Autowired
    private CategoryPersistencePort categoryRepository;

    @Override
    public Service save(NewServiceDTO serviceDTO) {
        Service service = this.serviceRepository.save(this.serviceBuilder.fromDTO(serviceDTO));
        //TODO HANDLE EMPTY LIST
        //TODO DO BUILDER
        NewCategoryListDTO categoriesDTO = new NewCategoryListDTO();
        categoriesDTO.setService(service);
        categoriesDTO.setCategoryNames(serviceDTO.getCategoriesName());
        //TODO DO BUILDER

        List<Category> categories = this.categoryBuilder.newCategoryList(categoriesDTO);
        this.categoryRepository.saveList(categories);

        return service;
    }

    @Override
    public Service update(Service service) {
        return null;
    }
}
