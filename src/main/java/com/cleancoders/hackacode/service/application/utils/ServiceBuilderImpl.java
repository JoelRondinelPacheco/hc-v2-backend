package com.cleancoders.hackacode.service.application.utils;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.service.application.dto.NewServiceDTO;
import com.cleancoders.hackacode.service.domain.ServiceBase;
import com.cleancoders.hackacode.service.domain.ServiceData;
import com.cleancoders.hackacode.service.domain.ServiceReference;

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
