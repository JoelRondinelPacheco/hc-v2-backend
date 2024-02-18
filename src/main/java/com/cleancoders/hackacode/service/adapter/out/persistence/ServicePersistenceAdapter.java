package com.cleancoders.hackacode.service.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.service.application.port.out.ServicePersistencePort;
import com.cleancoders.hackacode.service.domain.Service;

@PersistenceAdapter
public class ServicePersistenceAdapter implements ServicePersistencePort {
    @Override
    public Service save(Service service) {
        return null;
    }

    @Override
    public Service update(Service service) {
        return null;
    }
}
