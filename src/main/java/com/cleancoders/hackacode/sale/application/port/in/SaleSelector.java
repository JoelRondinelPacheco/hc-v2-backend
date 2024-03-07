package com.cleancoders.hackacode.sale.application.port.in;

import com.cleancoders.hackacode.sale.domain.SaleData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Date;

public interface SaleSelector {
    Page<SaleData> getPage(Pageable pageable);
    SaleData getSalesByMonth(LocalDate date);
    Page<SaleData> getSalesByMonth(Date date, Pageable pageable);
    Page<SaleData> getSalesByDay(Date date, Pageable pageable);
    Page<SaleData> getSalesByDay(Date date);
}
