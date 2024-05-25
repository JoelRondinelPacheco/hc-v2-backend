package com.cleancoders.hackacode.sale.application.port.out;

import com.cleancoders.hackacode.sale.domain.SaleData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Date;

public interface SaleSelectorPort {

    Page<SaleData> getPage(Pageable pageable);
    Page<SaleData> getSalesByMonth(LocalDate date, Pageable pageable);

    public Page<SaleData> getSalesByDay(LocalDate date, Pageable pageable);

    SaleData saleByMonth(LocalDate localDate);
}
