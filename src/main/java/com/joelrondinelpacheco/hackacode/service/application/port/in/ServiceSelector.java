package com.joelrondinelpacheco.hackacode.service.application.port.in;

import com.joelrondinelpacheco.hackacode.sale.application.dto.SaleItemDTO;
import com.joelrondinelpacheco.hackacode.sale.domain.SaleItemReference;
import com.joelrondinelpacheco.hackacode.service.domain.ServiceData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceSelector {
    ServiceData byId(Long id);
    List<ServiceData> listById(List<Long> ids);

    List<SaleItemReference> saleItemsInfo(List<SaleItemDTO> saleItemDTOS);

    Page<ServiceData> getAll(Pageable pageable);
}
