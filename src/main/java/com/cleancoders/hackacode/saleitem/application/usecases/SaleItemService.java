package com.cleancoders.hackacode.saleitem.application.usecases;

import com.cleancoders.hackacode.saleitem.domain.SaleItem;
import com.cleancoders.hackacode.service.domain.Service;

import java.util.List;

public interface SaleItemService {

    SaleItem createSaleItem(List<Service> services);
}
