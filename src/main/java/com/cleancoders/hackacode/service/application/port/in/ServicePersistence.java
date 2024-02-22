package com.cleancoders.hackacode.service.application.port.in;

import com.cleancoders.hackacode.service.application.dto.NewCategoryDTO;
import com.cleancoders.hackacode.service.application.dto.NewServiceDTO;
import com.cleancoders.hackacode.service.domain.Service;

import java.util.List;

public interface ServicePersistence {

    Service newService(NewServiceDTO service);
    Service update(Service service);
}
