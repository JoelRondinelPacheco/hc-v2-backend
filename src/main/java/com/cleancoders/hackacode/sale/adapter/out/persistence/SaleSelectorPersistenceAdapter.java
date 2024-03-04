package com.cleancoders.hackacode.sale.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.sale.application.port.out.SaleSelectorPort;
import com.cleancoders.hackacode.sale.domain.SaleData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@PersistenceAdapter
public class SaleSelectorPersistenceAdapter implements SaleSelectorPort {

    @Override
    public Page<SaleData> getPage(Pageable pageable) {
        return null;
    }
}
