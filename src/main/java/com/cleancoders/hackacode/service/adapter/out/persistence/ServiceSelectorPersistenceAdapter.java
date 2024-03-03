package com.cleancoders.hackacode.service.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.service.adapter.out.persistence.entity.ServiceEntity;
import com.cleancoders.hackacode.service.adapter.out.persistence.mapper.ServiceMapper;
import com.cleancoders.hackacode.service.adapter.out.persistence.repository.ServiceMySQLRepository;
import com.cleancoders.hackacode.service.application.dto.ServicePriceInfo;
import com.cleancoders.hackacode.service.application.dto.ServicePriceInfoImpl;
import com.cleancoders.hackacode.service.application.port.out.ServiceSelectorPort;
import com.cleancoders.hackacode.service.domain.ServiceBase;
import com.cleancoders.hackacode.service.domain.ServiceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@PersistenceAdapter
public class ServiceSelectorPersistenceAdapter implements ServiceSelectorPort {

    @Autowired
    private ServiceMySQLRepository serviceRepository;

    @Autowired
    private ServiceMapper mapper;

    @Override
    public ServiceData byId(Long id) {
        return this.serviceRepository.findById(id).map(this.mapper::entityToDomain).orElseThrow();
    }

    @Override
    public List<ServiceData> listById(List<Long> ids) {
        return this.serviceRepository.findAllById(ids)
                .stream().map(this.mapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Page<ServiceData> getAll(Pageable pageable) {
        System.out.println("get all");
        Page<ServiceData> s = this.serviceRepository.findAll(pageable).map(this.mapper::entityToDomain);
        System.out.println(s.getTotalElements());
        for(ServiceData se : s.getContent()) {
            System.out.println(se.getId());
            System.out.println(se.getName());
        }
        return this.serviceRepository.findAll(pageable).map(this.mapper::entityToDomain);
    }

    @Override
    public List<ServicePriceInfo> servicePrice(List<Long> ids) {
        //return this.serviceRepository.findAllServicePriceInfo(ids);
        List<ServiceEntity> serviceEntities = this.serviceRepository.findAllById(ids);
        //todo refactor
        List<ServicePriceInfo> sr = new ArrayList<>();
        for (ServiceEntity s : serviceEntities) {
            sr.add(new ServicePriceInfoImpl(s.getId(), s.getPrice()));
        }
        return sr;
    }

    public ServiceEntity entityById(Long id) {
        return this.serviceRepository.findById(id).orElseThrow();
    }
}
