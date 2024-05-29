package com.joelrondinelpacheco.hackacode.service.application.port.out;

import com.joelrondinelpacheco.hackacode.service.application.dto.NewServiceDTO;
import com.joelrondinelpacheco.hackacode.service.domain.ServiceData;

public interface ServicePersistencePort {
    ServiceData newService(NewServiceDTO serviceBase);
    ServiceData update(ServiceData serviceBase);
}
