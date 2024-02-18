package com.cleancoders.hackacode.service.application.port.out;

import com.cleancoders.hackacode.service.domain.Service;

public interface ServicePersistencePort {
    Service save(Service service);
    Service update(Service service);
}
