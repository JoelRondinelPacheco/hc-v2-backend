package com.cleancoders.hackacode.sale.application.port.in;

import com.cleancoders.hackacode.sale.domain.SaleData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Date;

public interface SaleSelector {
    Page<SaleData> getPage(Pageable pageable);
    SaleData getSalesByMonth(LocalDate date);
    Page<SaleData> getSalesByMonth(LocalDate date, Pageable pageable);
    Page<SaleData> getSalesByDay(LocalDate date, Pageable pageable);
    Page<SaleData> getSalesByDay(LocalDate date);
}
