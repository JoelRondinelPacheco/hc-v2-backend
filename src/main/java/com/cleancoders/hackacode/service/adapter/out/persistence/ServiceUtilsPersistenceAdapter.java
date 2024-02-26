package com.cleancoders.hackacode.service.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.service.adapter.out.persistence.repository.ServiceMySQLRepository;
import com.cleancoders.hackacode.service.application.port.out.ServiceUtilsPort;
import org.springframework.beans.factory.annotation.Autowired;

@PersistenceAdapter
public class ServiceUtilsPersistenceAdapter implements ServiceUtilsPort {
    @Autowired
    private ServiceMySQLRepository serviceMySQLRepository;

    @Override
    public boolean existsById(Long id) {
        return this.serviceMySQLRepository.existsById(id);
    }
}
