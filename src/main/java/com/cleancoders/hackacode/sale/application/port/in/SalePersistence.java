package com.cleancoders.hackacode.sale.application.port.in;

import com.cleancoders.hackacode.sale.application.dto.NewSaleDTO;
import com.cleancoders.hackacode.sale.domain.Sale;
import com.cleancoders.hackacode.sale.domain.SaleData;

public interface SalePersistence {

    Sale createSale(NewSaleDTO saleDTO);
}
