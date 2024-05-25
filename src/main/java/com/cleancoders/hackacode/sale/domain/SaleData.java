package com.cleancoders.hackacode.sale.domain;

import com.cleancoders.hackacode.client.domain.Client;
import com.cleancoders.hackacode.paymentmethod.domain.PaymentMethod;
import com.cleancoders.hackacode.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class SaleData extends Sale {
    private LocalDate createdAt;
    private Client client;
    private User user;
    private List<SaleItemData> saleItem;
}
