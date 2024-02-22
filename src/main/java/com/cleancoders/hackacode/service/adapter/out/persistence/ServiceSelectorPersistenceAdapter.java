package com.cleancoders.hackacode.service.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.service.adapter.out.persistence.entity.ServiceEntity;
import com.cleancoders.hackacode.service.adapter.out.persistence.repository.ServiceMySQLRepository;
import com.cleancoders.hackacode.service.application.port.out.ServiceSelectorPort;
import com.cleancoders.hackacode.service.domain.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@PersistenceAdapter
public class ServiceSelectorPersistenceAdapter implements ServiceSelectorPort {

    @Autowired
    private ServiceMySQLRepository serviceRepository;

    @Autowired
    @Qualifier("serviceMapper")
    private Mapper<Service, ServiceEntity> mapper;

    @Override
    public Service byId(Long id) {
        return null;
    }

    @Override
    public List<Service> listById(List<Long> ids) {
        return null;
    }

    @Override
    public Page<Service> getAll(Pageable pageable) {
        return this.serviceRepository.findAll(pageable).map(this.mapper::entityToDomain);
    }
}
