package com.cleancoders.hackacode.sale.adapter.out.persistence;

import com.cleancoders.hackacode.client.adapter.out.persistence.ClientEntity;
import com.cleancoders.hackacode.employee.adapter.out.persistence.EmployeeEntity;
import com.cleancoders.hackacode.paymentmethod.adapter.out.persistence.PaymentMethodEntity;
import com.cleancoders.hackacode.sale.domain.SaleType;
import com.cleancoders.hackacode.service.adapter.out.persistence.entity.ServiceEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class SaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethodEntity paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

    @ManyToMany
    private List<ServiceEntity> services;

    @Enumerated(EnumType.STRING)
    private SaleType type;
}
