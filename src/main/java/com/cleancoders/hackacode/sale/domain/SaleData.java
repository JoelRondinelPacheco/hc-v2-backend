package com.cleancoders.hackacode.sale.domain;

import com.cleancoders.hackacode.client.domain.Client;
import com.cleancoders.hackacode.paymentmethod.domain.PaymentMethod;
import com.cleancoders.hackacode.service.domain.ServiceData;
import com.cleancoders.hackacode.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class SaleData extends Sale {
    private PaymentMethod paymentMethod;
    private Client client;
    private User user;
    private List<ServiceData> services;
}
