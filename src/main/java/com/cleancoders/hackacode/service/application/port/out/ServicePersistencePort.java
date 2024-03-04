package com.cleancoders.hackacode.service.application.port.out;

import com.cleancoders.hackacode.service.application.dto.NewServiceDTO;
import com.cleancoders.hackacode.service.domain.ServiceData;
import com.cleancoders.hackacode.service.domain.ServiceReference;

public interface ServicePersistencePort {
    ServiceData newService(NewServiceDTO serviceBase);
    ServiceData update(ServiceData serviceBase);
}
