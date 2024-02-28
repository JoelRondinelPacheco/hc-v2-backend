package com.cleancoders.hackacode.service.application.utils;

import com.cleancoders.hackacode.service.application.dto.ServicePriceInfo;

import java.util.List;

public interface ServiceUtils {

    void assertExistsById(Long id);

    ServicePriceInfo servicePriceInfo(Long id);
    List<ServicePriceInfo> servicePriceInfoList(List<Long> ids);
}
