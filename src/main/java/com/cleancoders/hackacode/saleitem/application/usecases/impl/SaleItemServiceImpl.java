package com.cleancoders.hackacode.saleitem.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.saleitem.application.usecases.SaleItemService;
import com.cleancoders.hackacode.saleitem.domain.Package;
import com.cleancoders.hackacode.saleitem.domain.SaleItem;
import com.cleancoders.hackacode.service.domain.Service;

import java.util.List;

@UseCase
public class SaleItemServiceImpl implements SaleItemService {
    @Override
    public SaleItem createSaleItem(List<Service> services) {

        if (services.size() == 1) {
            return services.get(0);
        } else if (services.size() > 1) {
            return Package.withServices(services);
        }

        throw new RuntimeException("TODO CUSTOM EX");
    }
}
