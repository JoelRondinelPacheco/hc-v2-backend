package com.cleancoders.hackacode.sale.application.port.out;

import com.cleancoders.hackacode.sale.domain.SaleData;
import com.cleancoders.hackacode.sale.domain.SaleReference;

public interface SalePersistencePort {

    SaleData newSale(SaleReference saleData);
}
