package com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.mapper;

import com.joelrondinelpacheco.hackacode.common.adapter.Mapper;
import com.joelrondinelpacheco.hackacode.common.adapter.MapperDTO;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.entity.ServiceEntity;
import com.joelrondinelpacheco.hackacode.service.application.dto.NewServiceDTO;
import com.joelrondinelpacheco.hackacode.service.domain.ServiceData;

import java.util.List;

public interface ServiceMapper extends Mapper<ServiceData, ServiceEntity>, MapperDTO<NewServiceDTO, ServiceEntity> {
    List<ServiceData> entityToDomainList(List<ServiceEntity> services);
}
