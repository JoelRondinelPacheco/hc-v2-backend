package com.cleancoders.hackacode.service.application.port.in;

import com.cleancoders.hackacode.service.application.dto.ServicePriceInfo;
import com.cleancoders.hackacode.service.domain.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceSelector {
    Service byId(Long id);
    List<Service> listById(List<Long> ids);

    List<ServicePriceInfo> servicePriceList(List<Long> ids);

    Page<Service> getAll(Pageable pageable);
}
