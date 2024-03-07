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
    public Page<SaleData> getSalesByMonth(Date date, Pageable pageable) {
        return null;
    }

    @Override
    public Page<SaleData> getSalesByDay(Date date, Pageable pageable) {
        return null;
    }

    @Override
    public SaleData saleByMonth(LocalDate localDate) {

        List<SaleEntity> s1 = this.saleMySQLRepository.fetchByMonthAndYearAndDay(localDate.getMonthValue(), localDate.getYear(), localDate.getDayOfMonth());
        for(SaleEntity sd : s1) {
            System.out.println("dia");
            System.out.println(sd.getId());
            System.out.println(sd.getPrice());
            System.out.println(sd.getCreatedAt());
        }

        List<SaleEntity> s2 = this.saleMySQLRepository.fetchByMonth(localDate.getMonthValue());
        for(SaleEntity se : s2) {
            System.out.println(se.getId());
            System.out.println(se.getPrice());
            System.out.println(se.getCreatedAt());
        }

        List<SaleEntity> s3 = this.saleMySQLRepository.fetchByMonthAndYear(localDate.getMonthValue(), localDate.getYear());
        for(SaleEntity sc : s3) {
            System.out.println(sc.getId());
            System.out.println(sc.getPrice());
            System.out.println(sc.getCreatedAt());
        }
        return null;
    }
}
