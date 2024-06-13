package com.joelrondinelpacheco.hackacode.paymentmethod.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "payment_method")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PaymentMethodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String type;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal interest;
}
