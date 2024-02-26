package com.cleancoders.hackacode.service.application.port.in;

import com.cleancoders.hackacode.service.application.dto.EditServiceDTO;
import com.cleancoders.hackacode.service.application.dto.NewCategoryDTO;
import com.cleancoders.hackacode.service.application.dto.NewServiceDTO;
import com.cleancoders.hackacode.service.domain.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServicePersistence {

    Service newService(NewServiceDTO service);
    Service update(EditServiceDTO service);

    Page<Service> getByPage(Pageable pageable);

    String deleteService(String serviceId);
}
