package com.cleancoders.hackacode.sale.adapter.out.persistence;

import com.cleancoders.hackacode.client.adapter.out.persistence.ClientEntity;
import com.cleancoders.hackacode.user.adapter.out.persistence.UserEntity;
import com.cleancoders.hackacode.paymentmethod.adapter.out.persistence.PaymentMethodEntity;
import com.cleancoders.hackacode.sale.domain.SaleType;
import com.cleancoders.hackacode.service.adapter.out.persistence.entity.ServiceEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity(name = "sale")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethodEntity paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private UserEntity employee;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "rel_sales_services",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<ServiceEntity> services;

    @Enumerated(EnumType.STRING)
    private SaleType type;

    private BigDecimal price;
    /*
    TODO PREGUNTA, SI CONTRATA MAS DE UNA VEZ UN MISMO SERVICIO (EJM HABITACION MUCHOS DIAS) CUENTA COMO MUCHOS SERVICIOS O UNO SOLO
     */
}
