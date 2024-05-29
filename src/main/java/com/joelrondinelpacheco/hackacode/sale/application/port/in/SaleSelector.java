package com.joelrondinelpacheco.hackacode.sale.application.port.in;

import com.joelrondinelpacheco.hackacode.sale.domain.SaleData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface SaleSelector {
    Page<SaleData> getPage(Pageable pageable);
    SaleData getSalesByMonth(LocalDate date);
    Page<SaleData> getSalesByMonth(LocalDate date, Pageable pageable);
    Page<SaleData> getSalesByDay(LocalDate date, Pageable pageable);
    Page<SaleData> getSalesByDay(LocalDate date);
}
