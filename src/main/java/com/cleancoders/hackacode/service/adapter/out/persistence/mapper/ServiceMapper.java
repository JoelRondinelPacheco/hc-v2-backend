package com.cleancoders.hackacode.service.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.service.adapter.out.persistence.entity.ServiceEntity;
import com.cleancoders.hackacode.service.domain.Service;

import java.util.List;

public interface ServiceMapper extends Mapper<Service, ServiceEntity> {
    List<Service> entityToDomainList(List<ServiceEntity> services);
}
