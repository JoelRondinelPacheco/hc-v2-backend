package com.cleancoders.hackacode.service.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.service.application.port.out.ServiceUtilsPort;
import com.cleancoders.hackacode.service.application.utils.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class ServiceUtilsImpl implements ServiceUtils {

    @Autowired
    private ServiceUtilsPort serviceUtilsPort;

    @Override
    public void assertExistsById(Long id) {
        if (!this.serviceUtilsPort.existsById(id)) {
            throw new RuntimeException("TODO");
        }
    }
}
