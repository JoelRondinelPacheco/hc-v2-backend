package com.cleancoders.hackacode.service.application.port.out;

import com.cleancoders.hackacode.service.domain.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceSelectorPort {
    Service byId(Long id);
    List<Service> listById(List<Long> ids);

    Page<Service> getAll(Pageable pageable);

}
