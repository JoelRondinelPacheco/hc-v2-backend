package com.joelrondinelpacheco.hackacode.sale.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NewSaleDTO {
    private Long paymentMethodId;
    private Long clientId;
    private Long employeeId;
    private List<SaleItemDTO> saleItems;

}
