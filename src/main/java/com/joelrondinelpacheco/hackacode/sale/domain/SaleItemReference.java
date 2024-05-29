package com.joelrondinelpacheco.hackacode.sale.domain;

import com.joelrondinelpacheco.hackacode.service.domain.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class SaleItemReference extends SaleItemBase{
    private Service service;
}
