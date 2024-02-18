package com.cleancoders.hackacode.service.application.utils;

import com.cleancoders.hackacode.service.application.dto.NewServiceDTO;
import com.cleancoders.hackacode.service.domain.Service;

public interface ServiceBuilder {
    Service fromDTO(NewServiceDTO dto);
}
