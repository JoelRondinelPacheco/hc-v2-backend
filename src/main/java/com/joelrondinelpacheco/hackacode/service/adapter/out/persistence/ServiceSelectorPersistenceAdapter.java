package com.joelrondinelpacheco.hackacode.service.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.entity.ServiceEntity;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.mapper.ServiceMapper;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.repository.ServiceMySQLRepository;
import com.joelrondinelpacheco.hackacode.service.application.dto.ServicePriceInfo;
import com.joelrondinelpacheco.hackacode.service.application.dto.ServicePriceInfoImpl;
import com.joelrondinelpacheco.hackacode.service.application.port.out.ServiceSelectorPort;
import com.joelrondinelpacheco.hackacode.service.domain.ServiceData;
import org.springframework.beans.factory.annotation.Autowired;
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
        ServiceEntity s = this.serviceRepository.findById(id).orElseThrow();
        ServiceData sd = this.mapper.entityToDomain(s);
        return sd;
    }

    @Override
    public List<ServiceData> listById(List<Long> ids) {
        return this.serviceRepository.findAllById(ids)
                .stream().map(this.mapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Page<ServiceData> getAll(Pageable pageable) {
        //TODO REFACTOR
        Page<ServiceData> s = this.serviceRepository.findAll(pageable).map(this.mapper::entityToDomain);
        System.out.println(s);
        return s;
    }

    @Override
    public List<ServicePriceInfo> servicePriceList(List<Long> ids) {
        //return this.serviceRepository.findAllServicePriceInfo(ids);
        List<ServiceEntity> serviceEntities = this.serviceRepository.findAllById(ids);
        //todo refactor
        List<ServicePriceInfo> sr = new ArrayList<>();
        for (ServiceEntity s : serviceEntities) {
            sr.add(new ServicePriceInfoImpl(s.getId(), s.getPrice()));
        }
        return sr;
    }

    @Override
    public ServicePriceInfoImpl servicePrice(Long id) {
        ServiceEntity s = this.serviceRepository.findById(id).orElseThrow();
        return new ServicePriceInfoImpl(s.getId(), s.getPrice());
    }

    public ServiceEntity entityById(Long id) {
        return this.serviceRepository.findById(id).orElseThrow();
    }
}
