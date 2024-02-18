package com.cleancoders.hackacode.sale.application.dto;

import jdk.jfr.DataAmount;

import java.util.List;

public class NewSaleDTO {
    private Long clientId;
    private Long employeeId;
    private List<Long> servicesId;

    public Long getClientId() {
        return clientId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public List<Long> getServicesId() {
        return servicesId;
    }
}
