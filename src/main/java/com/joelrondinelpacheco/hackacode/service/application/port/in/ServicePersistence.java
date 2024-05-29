package com.joelrondinelpacheco.hackacode.service.application.port.in;

import com.joelrondinelpacheco.hackacode.service.application.dto.EditServiceDTO;
import com.joelrondinelpacheco.hackacode.service.application.dto.NewServiceDTO;
import com.joelrondinelpacheco.hackacode.service.domain.ServiceData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServicePersistence {

    ServiceData newService(NewServiceDTO service);
    ServiceData update(EditServiceDTO service);

    Page<ServiceData> getByPage(Pageable pageable);

    String deleteService(String serviceId);
}
