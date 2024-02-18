package com.cleancoders.hackacode.service.application.port.out;

import com.cleancoders.hackacode.service.domain.Service;

import java.util.List;

public interface ServiceSelectorPort {
    Service byId(Long id);
    List<Service> listById(List<Long> ids);
}
