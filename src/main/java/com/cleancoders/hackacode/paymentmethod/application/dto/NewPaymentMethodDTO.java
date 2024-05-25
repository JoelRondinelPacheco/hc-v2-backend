package com.cleancoders.hackacode.paymentmethod.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NewPaymentMethodDTO {
    private String type;
    private BigDecimal interest;
}
