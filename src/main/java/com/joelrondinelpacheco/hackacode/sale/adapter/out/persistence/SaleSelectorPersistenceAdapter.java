package com.joelrondinelpacheco.hackacode.sale.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.sale.adapter.out.persistence.mapper.SaleMapper;
import com.joelrondinelpacheco.hackacode.sale.application.port.out.SaleSelectorPort;
import com.joelrondinelpacheco.hackacode.sale.domain.SaleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

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

    @Override
    public Page<SaleData> getSalesByMonth(LocalDate date, Pageable pageable) {
        return this.saleMySQLRepository.fetchByMonthAndYear(date.getMonthValue(), date.getYear(), pageable).map(this.mapper::entityToDomain);
    }

    @Override
    public Page<SaleData> getSalesByDay(LocalDate date, Pageable pageable) {
        return this.saleMySQLRepository.fetchByMonthAndYearAndDay(date.getMonthValue(), date.getYear(), date.getDayOfMonth(), pageable).map(this.mapper::entityToDomain);
    }

    @Override
    public SaleData saleByMonth(LocalDate localDate) {

       return null;
    }
}
