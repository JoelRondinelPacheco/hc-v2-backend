package com.cleancoders.hackacode.service.application.port.out;

import com.cleancoders.hackacode.service.application.dto.ServicePriceInfo;
import com.cleancoders.hackacode.service.application.dto.ServicePriceInfoImpl;
import com.cleancoders.hackacode.service.domain.ServiceData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceSelectorPort {
    ServiceData byId(Long id);
    List<ServiceData> listById(List<Long> ids);

    Page<ServiceData> getAll(Pageable pageable);

    List<ServicePriceInfo> servicePriceList(List<Long> ids);
    ServicePriceInfoImpl servicePrice(Long id);
}
