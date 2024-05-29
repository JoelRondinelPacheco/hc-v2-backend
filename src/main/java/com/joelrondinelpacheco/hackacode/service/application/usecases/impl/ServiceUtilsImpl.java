package com.joelrondinelpacheco.hackacode.service.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.service.application.dto.ServicePriceInfo;
import com.joelrondinelpacheco.hackacode.service.application.port.out.ServiceUtilsPort;
import com.joelrondinelpacheco.hackacode.service.application.utils.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    @Override
    public ServicePriceInfo servicePriceInfo(Long id) {
        return null;
    }

    @Override
    public List<ServicePriceInfo> servicePriceInfoList(List<Long> ids) {
        return null;
    }
}
