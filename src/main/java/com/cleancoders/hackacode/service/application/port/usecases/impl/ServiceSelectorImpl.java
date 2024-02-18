package com.cleancoders.hackacode.service.application.port.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.service.application.port.in.ServiceSelector;
import com.cleancoders.hackacode.service.application.port.out.ServiceSelectorPort;
import com.cleancoders.hackacode.service.domain.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@UseCase
public class ServiceSelectorImpl implements ServiceSelector {

    @Autowired
    private ServiceSelectorPort serviceSelectorPort;

    @Override
    public Service byId(Long id) {
        return null;
    }

    @Override
    public List<Service> listById(List<Long> ids) {
        List<Service> services = new ArrayList<>();

        for (Long id : ids) {
            services.add(this.byId(id));
        }

        return services;
    }
}
