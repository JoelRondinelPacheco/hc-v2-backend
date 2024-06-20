package com.joelrondinelpacheco.hackacode.paymentmethod.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
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
    @NotNull
    @NotEmpty
    private String type;
    @NotNull
    @PositiveOrZero
    private BigDecimal interest;
}
