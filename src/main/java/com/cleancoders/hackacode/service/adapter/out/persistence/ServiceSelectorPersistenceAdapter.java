package com.cleancoders.hackacode.service.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.service.application.port.out.ServiceSelectorPort;
import com.cleancoders.hackacode.service.domain.Service;

import java.util.List;

@PersistenceAdapter
public class ServiceSelectorPersistenceAdapter implements ServiceSelectorPort {
    @Override
    public Service byId(Long id) {
        return null;
    }

    @Override
    public List<Service> listById(List<Long> ids) {
        return null;
    }
}
