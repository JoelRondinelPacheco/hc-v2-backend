package com.cleancoders.hackacode.sale.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class SaleReference extends Sale {
    private Long paymentMethod;
    private Long client;
    private Long employee;
}
