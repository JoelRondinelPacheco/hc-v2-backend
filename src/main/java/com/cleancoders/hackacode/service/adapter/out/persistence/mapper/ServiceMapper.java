package com.cleancoders.hackacode.service.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.service.adapter.out.persistence.entity.ServiceEntity;
import com.cleancoders.hackacode.service.domain.Service;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceMapper
@Qualifier("serviceMapper")
public class ServiceMapper implements Mapper<Service, ServiceEntity> {
    @Override
    public Service entityToDomain(ServiceEntity serviceEntity) {
        return null;
    }

    @Override
    public ServiceEntity domainToEntity(Service service) {
        return null;
    }
}
