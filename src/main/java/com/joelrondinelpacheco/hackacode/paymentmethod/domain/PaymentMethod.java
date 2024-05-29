package com.joelrondinelpacheco.hackacode.paymentmethod.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class PaymentMethod extends PaymentMethodBase{
    private String type;
}
