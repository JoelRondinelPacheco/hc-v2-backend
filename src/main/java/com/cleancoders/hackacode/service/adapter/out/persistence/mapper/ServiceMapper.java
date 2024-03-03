package com.cleancoders.hackacode.service.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.common.adapter.MapperDTO;
import com.cleancoders.hackacode.service.adapter.out.persistence.entity.ServiceEntity;
import com.cleancoders.hackacode.service.application.dto.NewServiceDTO;
import com.cleancoders.hackacode.service.domain.Service;
import com.cleancoders.hackacode.service.domain.ServiceBase;
import com.cleancoders.hackacode.service.domain.ServiceData;

import java.util.List;

public interface ServiceMapper extends Mapper<ServiceData, ServiceEntity>, MapperDTO<NewServiceDTO, ServiceEntity> {
    List<ServiceData> entityToDomainList(List<ServiceEntity> services);
}
