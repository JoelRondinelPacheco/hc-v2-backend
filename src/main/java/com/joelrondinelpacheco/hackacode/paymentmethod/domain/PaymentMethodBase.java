package com.joelrondinelpacheco.hackacode.paymentmethod.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class PaymentMethodBase {
    private Long id;
    private BigDecimal interest;
}
