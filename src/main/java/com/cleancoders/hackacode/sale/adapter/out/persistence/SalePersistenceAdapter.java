package com.cleancoders.hackacode.sale.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.sale.application.port.out.SalePersistencePort;
import com.cleancoders.hackacode.sale.domain.Sale;
import com.cleancoders.hackacode.sale.domain.SaleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceAdapter
public class SalePersistenceAdapter implements SalePersistencePort {

    @Autowired
    private SaleMySQLRepository saleRepository;
    @Autowired
    @Qualifier("saleMapper")
    private Mapper<Sale, SaleEntity> mapper;

    @Override
    public Sale save(Sale saleData) {
        return null;
    }
}
