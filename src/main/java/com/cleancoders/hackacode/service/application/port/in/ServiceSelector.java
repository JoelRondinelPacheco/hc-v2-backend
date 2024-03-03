package com.cleancoders.hackacode.service.application.port.in;

import com.cleancoders.hackacode.service.application.dto.ServicePriceInfo;
import com.cleancoders.hackacode.service.domain.ServiceBase;
import com.cleancoders.hackacode.service.domain.ServiceData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceSelector {
    ServiceData byId(Long id);
    List<ServiceData> listById(List<Long> ids);

    List<ServicePriceInfo> servicePriceList(List<Long> ids);

    Page<ServiceData> getAll(Pageable pageable);
}
