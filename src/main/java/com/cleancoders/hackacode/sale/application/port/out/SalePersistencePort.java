package com.cleancoders.hackacode.sale.application.port.out;

import com.cleancoders.hackacode.sale.domain.Sale;
import com.cleancoders.hackacode.sale.domain.SaleData;

public interface SalePersistencePort {

    Sale save(Sale saleData);
}
