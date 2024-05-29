package com.joelrondinelpacheco.hackacode.sale.application.port.in;

import com.joelrondinelpacheco.hackacode.sale.application.dto.NewSaleDTO;
import com.joelrondinelpacheco.hackacode.sale.domain.SaleData;

public interface SalePersistence {

    SaleData createSale(NewSaleDTO saleDTO);
}
