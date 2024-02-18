package com.cleancoders.hackacode.sale.domain;

import com.cleancoders.hackacode.client.domain.Client;
import com.cleancoders.hackacode.employee.domain.Employee;
import com.cleancoders.hackacode.paymentmethod.domain.PaymentMethod;
import com.cleancoders.hackacode.saleitem.domain.SaleItem;

import java.math.BigDecimal;

public class Sale {
    private Long id;
    private String num_sale; //????
    private PaymentMethod paymentMethod;
    private Client client;
    private Employee employee;
    private SaleItem saleItem;
    private SaleType type;

    public Sale(Builder builder) {
        this.client = builder.client;
        this.employee = builder.employee;
        this.saleItem = builder.saleItem;
        this.type = builder.type;
    }


    public static class Builder {
        private Client client;
        private Employee employee;
        private SaleItem saleItem;
        private SaleType type;

        public Sale.Builder client(Client client) {
            this.client = client;
            return this;
        }
        public Sale.Builder employee(Employee employee) {
            this.employee = employee;
            return this;
        }
        public Sale.Builder saleItem(SaleItem saleItem) {
            this.saleItem = saleItem;
            this.setType(saleItem.getItemsSize());
            return this;
        }

        private void setType(int size) {
            if (size > 1) {
                this.type = SaleType.PACKAGE;
            } else {
                this.type = SaleType.SINGLE_SALE;
            }
        }

        public Sale build(){
            return new Sale(this);
        }
    }

}
