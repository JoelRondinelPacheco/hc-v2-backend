package com.joelrondinelpacheco.hackacode.sale.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.sale.application.port.in.SaleSelector;
import com.joelrondinelpacheco.hackacode.sale.application.port.out.SaleSelectorPort;
import com.joelrondinelpacheco.hackacode.sale.domain.SaleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

@UseCase
public class SaleSelectorImpl implements SaleSelector {

    @Autowired
    private SaleSelectorPort saleSelectorPort;

    @Override
    public Page<SaleData> getPage(Pageable pageable) {
        return this.saleSelectorPort.getPage(pageable);
    }

    @Override
    public SaleData getSalesByMonth(LocalDate date) {
        return this.saleSelectorPort.saleByMonth(date);
    }

    @Override
    public Page<SaleData> getSalesByMonth(LocalDate date, Pageable pageable) {
        return this.saleSelectorPort.getSalesByMonth(date, pageable);
    }

    @Override
    public Page<SaleData> getSalesByDay(LocalDate date, Pageable pageable) {
        return this.saleSelectorPort.getSalesByDay(date, pageable);
    }

    @Override
    public Page<SaleData> getSalesByDay(LocalDate date) {
        return null;
    }
}
