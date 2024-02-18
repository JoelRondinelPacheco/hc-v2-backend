package com.cleancoders.hackacode.service.application.port.in;

import com.cleancoders.hackacode.service.domain.Service;

import java.util.List;

public interface ServiceSelector {
    Service byId(Long id);
    List<Service> listById(List<Long> ids);
}
