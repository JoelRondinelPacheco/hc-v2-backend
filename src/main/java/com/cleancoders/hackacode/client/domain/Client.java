package com.cleancoders.hackacode.client.domain;

import com.cleancoders.hackacode.sale.domain.Sale;
import com.cleancoders.hackacode.user.domain.User;

import java.util.List;

public class Client {
    private Long id;
    private User user;
    private List<Sale> sales;

    private Client(User user) {
        this.user = user;
    }

    public static Client withUser(User user) {
        return new Client(user);
    }
}
