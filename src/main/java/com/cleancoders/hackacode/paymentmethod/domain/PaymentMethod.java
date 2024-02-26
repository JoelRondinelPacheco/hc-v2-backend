package com.cleancoders.hackacode.paymentmethod.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PaymentMethod {
    private Long id;
    private String type;
    private BigDecimal interest;
}
