package com.cleancoders.hackacode.sale.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.sale.adapter.out.persistence.mapper.SaleMapper;
import com.cleancoders.hackacode.sale.application.port.out.SaleSelectorPort;
import com.cleancoders.hackacode.sale.domain.SaleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@PersistenceAdapter
public class SaleSelectorPersistenceAdapter implements SaleSelectorPort {

    @Autowired
    private SaleMySQLRepository saleMySQLRepository;
    @Autowired
    private SaleMapper mapper;
    @Override
    public Page<SaleData> getPage(Pageable pageable) {
        return this.saleMySQLRepository.findAll(pageable).map(this.mapper::entityToDomain);
    }
}
