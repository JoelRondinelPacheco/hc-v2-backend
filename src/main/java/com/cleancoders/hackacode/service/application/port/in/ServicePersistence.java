package com.cleancoders.hackacode.service.application.port.in;

import com.cleancoders.hackacode.service.application.dto.NewServiceDTO;
import com.cleancoders.hackacode.service.domain.Service;

public interface ServicePersistence {

    Service save(NewServiceDTO service);
    Service update(Service service);
}
