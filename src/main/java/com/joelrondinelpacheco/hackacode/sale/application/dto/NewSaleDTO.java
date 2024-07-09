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
    private String employeeEmail;
    private List<SaleItemDTO> saleItems;

}
