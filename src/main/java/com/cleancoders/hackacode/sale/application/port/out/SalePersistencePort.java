package com.cleancoders.hackacode.sale.application.port.out;

import com.cleancoders.hackacode.sale.domain.Sale;
import com.cleancoders.hackacode.sale.domain.SaleReference;

public interface SalePersistencePort {

    Sale newSale(SaleReference saleData);
}
