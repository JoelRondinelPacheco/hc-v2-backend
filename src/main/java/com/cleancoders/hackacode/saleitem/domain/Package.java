package com.cleancoders.hackacode.saleitem.domain;

import com.cleancoders.hackacode.service.domain.Service;

import java.math.BigDecimal;
import java.util.List;

public class Package implements SaleItem {
    private List<Service> services;
    private BigDecimal price;
    private final BigDecimal discount = new BigDecimal("0.9");

    private Package(List<Service> services) {
        this.services = services;
        this.setPrice(services);
    }

    public static Package withServices(List<Service> services) {
        return new Package(services);
    }

    private void setPrice(List<Service> services) {
        BigDecimal sum = BigDecimal.ZERO;

        for (Service service : services) {
            sum = sum.add(service.getPrice());
        }
        this.price = this.applyDiscount(sum);
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public List<Service> getServices() {
        return this.services;
    }

    @Override
    public int getItemsSize() {
        return this.services.size();
    }

    private BigDecimal applyDiscount(BigDecimal price) {
        return price.multiply(this.discount);
    }
}
