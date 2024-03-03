package com.cleancoders.hackacode.service.application.utils;

import com.cleancoders.hackacode.service.application.dto.NewServiceDTO;
import com.cleancoders.hackacode.service.domain.ServiceBase;
import com.cleancoders.hackacode.service.domain.ServiceReference;

public interface ServiceBuilder {
    ServiceReference fromDTO(NewServiceDTO dto);
}
