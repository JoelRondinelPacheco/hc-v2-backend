package com.cleancoders.hackacode.service.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.sale.application.dto.SaleItemDTO;
import com.cleancoders.hackacode.sale.domain.SaleItemReference;
import com.cleancoders.hackacode.service.application.dto.ServicePriceInfo;
import com.cleancoders.hackacode.service.application.dto.ServicePriceInfoImpl;
import com.cleancoders.hackacode.service.application.port.in.ServiceSelector;
import com.cleancoders.hackacode.service.application.port.out.ServiceSelectorPort;
import com.cleancoders.hackacode.service.domain.Service;
import com.cleancoders.hackacode.service.domain.ServiceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@UseCase
public class ServiceSelectorImpl implements ServiceSelector {

    @Autowired
    private ServiceSelectorPort serviceSelectorPort;

    @Override
    public ServiceData byId(Long id) {
        return null;
    }

    @Override
    public List<ServiceData> listById(List<Long> ids) {
        return this.serviceSelectorPort.listById(ids);
    }

    @Override
    public List<SaleItemReference> saleItemsInfo(List<SaleItemDTO> saleItemDTOS) {
        List<SaleItemReference> saleItemReferences = new ArrayList<>();

        for (SaleItemDTO saleItem : saleItemDTOS) {
            try {
                ServicePriceInfoImpl s = this.serviceSelectorPort.servicePrice(saleItem.getServiceId());
                saleItemReferences.add(SaleItemReference.builder()
                                .service(new Service(s.getId(), s.getPrice()))
                                .quantity(saleItem.getQuantity())
                                .from(saleItem.getFrom())
                                .to(saleItem.getTo())
                                .build());
            } catch (Exception e) {
                continue;
            }
        }

        return saleItemReferences;
    }

    @Override
    public Page<ServiceData> getAll(Pageable pageable) {
        return this.serviceSelectorPort.getAll(pageable);
    }
}
