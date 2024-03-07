package com.cleancoders.hackacode.sale.domain;

import com.cleancoders.hackacode.service.domain.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class SaleDataReference extends Sale {
    private Long paymentMethod;
    private Long client;
    private Long employee;
    private List<Service> services;

    private SaleDataReference(List<Service> services) {
        this.services = services;
        super.setPrice(services);
        super.setSaleType(services);
    }

    public static SaleDataReference withServices(List<Service> services) {
        return new SaleDataReference(services);
    }

}
