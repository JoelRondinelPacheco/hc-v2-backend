package com.cleancoders.hackacode.sale.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.sale.adapter.out.persistence.mapper.SaleMapper;
import com.cleancoders.hackacode.sale.application.port.out.SaleSelectorPort;
import com.cleancoders.hackacode.sale.domain.SaleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
        Page<SaleEntity> s = this.saleMySQLRepository.fetchByMonthAndYearAndDay(date.getMonthValue(), date.getDayOfMonth(), date.getYear(), pageable);
        System.out.println(s.getTotalElements());
        for (SaleEntity se : s.getContent()) {
            System.out.println(se.getId());
            System.out.println(se.getPrice());
        }
        return this.saleMySQLRepository.fetchByMonthAndYearAndDay(date.getMonthValue(), date.getYear(), date.getDayOfMonth(), pageable).map(this.mapper::entityToDomain);
    }

    @Override
    public SaleData saleByMonth(LocalDate localDate) {

       return null;
    }
}
