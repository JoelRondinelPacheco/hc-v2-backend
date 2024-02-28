package com.cleancoders.hackacode.saleitem.domain;

import com.cleancoders.hackacode.service.domain.Service;

import java.math.BigDecimal;
import java.util.List;

public interface SaleItem {

    BigDecimal getPrice();

    List<Service> getServices();
    int getItemsSize();

}
