package com.cleancoders.hackacode.sale.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.sale.application.port.in.SaleSelector;
import com.cleancoders.hackacode.sale.application.port.out.SaleSelectorPort;
import com.cleancoders.hackacode.sale.domain.SaleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Date;

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
    public Page<SaleData> getSalesByMonth(Date date, Pageable pageable) {
        return null;
    }

    @Override
    public Page<SaleData> getSalesByDay(Date date, Pageable pageable) {
        return null;
    }

    @Override
    public Page<SaleData> getSalesByDay(Date date) {
        return null;
    }
}
