package com.cleancoders.hackacode.sale.application.port.out;

import com.cleancoders.hackacode.sale.domain.SaleData;
import com.cleancoders.hackacode.sale.domain.SaleDataReference;

public interface SalePersistencePort {

    SaleData newSale(SaleDataReference saleData);
}
