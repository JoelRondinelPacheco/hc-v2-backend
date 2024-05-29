package com.joelrondinelpacheco.hackacode.service.application.utils;

import com.joelrondinelpacheco.hackacode.service.application.dto.NewServiceDTO;
import com.joelrondinelpacheco.hackacode.service.domain.ServiceReference;

public interface ServiceBuilder {
    ServiceReference fromDTO(NewServiceDTO dto);
}
