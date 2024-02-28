package com.cleancoders.hackacode.service.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.service.application.dto.ServicePriceInfo;
import com.cleancoders.hackacode.service.application.port.in.ServiceSelector;
import com.cleancoders.hackacode.service.application.port.out.ServiceSelectorPort;
import com.cleancoders.hackacode.service.domain.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
        return this.serviceSelectorPort.listById(ids);
    }

    @Override
    public List<ServicePriceInfo> servicePriceList(List<Long> ids) {
        return this.serviceSelectorPort.servicePrice(ids);
    }

    @Override
    public Page<Service> getAll(Pageable pageable) {
        return this.serviceSelectorPort.getAll(pageable);
    }
}
