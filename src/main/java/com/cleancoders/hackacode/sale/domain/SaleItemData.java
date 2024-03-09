package com.cleancoders.hackacode.sale.domain;

import com.cleancoders.hackacode.service.domain.ServiceData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class SaleItemData extends SaleItemBase {
    private ServiceData service;
}
