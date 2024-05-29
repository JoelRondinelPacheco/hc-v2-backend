package com.joelrondinelpacheco.hackacode.service.application.utils;

import com.joelrondinelpacheco.hackacode.service.application.dto.ServicePriceInfo;

import java.util.List;

public interface ServiceUtils {

    void assertExistsById(Long id);

    ServicePriceInfo servicePriceInfo(Long id);
    List<ServicePriceInfo> servicePriceInfoList(List<Long> ids);
}
