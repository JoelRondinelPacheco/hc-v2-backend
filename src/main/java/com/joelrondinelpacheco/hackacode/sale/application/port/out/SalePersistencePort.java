package com.joelrondinelpacheco.hackacode.sale.application.port.out;

import com.joelrondinelpacheco.hackacode.sale.domain.SaleData;
import com.joelrondinelpacheco.hackacode.sale.domain.SaleReference;

public interface SalePersistencePort {

    SaleData newSale(SaleReference saleData);
}
