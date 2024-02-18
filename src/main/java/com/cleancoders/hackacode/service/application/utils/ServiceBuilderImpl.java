package com.cleancoders.hackacode.service.application.utils;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.service.application.dto.NewServiceDTO;
import com.cleancoders.hackacode.service.domain.Service;

@UseCase
public class ServiceBuilderImpl implements ServiceBuilder{

    @Override
    public Service fromDTO(NewServiceDTO dto) {
        return new Service.ServiceBuilder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .build();
    }
}
