package com.cleancoders.hackacode.sale.domain;

import com.cleancoders.hackacode.service.domain.ServiceData;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SaleItem {
    private String id;
    private ServiceData service;
    private int quantity;
    private BigDecimal interest;
    private BigDecimal discount;
    private LocalDate from;
    private LocalDate to;
}
