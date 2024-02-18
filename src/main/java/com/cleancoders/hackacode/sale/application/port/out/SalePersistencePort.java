package com.cleancoders.hackacode.sale.application.port.out;

import com.cleancoders.hackacode.sale.domain.Sale;

public interface SalePersistencePort {

    Sale save(Sale sale);
}
