package com.joelrondinelpacheco.hackacode.sale.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.client.adapter.out.persistence.ClientEntity;
import com.joelrondinelpacheco.hackacode.employee.adapter.out.persistence.EmployeeEntity;
import com.joelrondinelpacheco.hackacode.paymentmethod.adapter.out.persistence.PaymentMethodEntity;
import com.joelrondinelpacheco.hackacode.sale.domain.SaleType;
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethodEntity paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

    @OneToMany(mappedBy = "sale", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<SaleItemEntity> saleItem;

    @Enumerated(EnumType.STRING)
    private SaleType type;

    private BigDecimal total;
    private BigDecimal discount;
    private BigDecimal interest;
}
