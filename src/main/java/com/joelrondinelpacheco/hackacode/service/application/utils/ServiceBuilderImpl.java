package com.joelrondinelpacheco.hackacode.service.application.utils;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.service.application.dto.NewServiceDTO;
import com.joelrondinelpacheco.hackacode.service.domain.ServiceReference;

@UseCase
public class ServiceBuilderImpl implements ServiceBuilder{

    @Override
    public ServiceReference fromDTO(NewServiceDTO dto) {
        return ServiceReference.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .category(dto.getCategoryId())
                .build();
    }
}
