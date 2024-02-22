package com.cleancoders.hackacode.client.domain;

import com.cleancoders.hackacode.sale.domain.Sale;
import com.cleancoders.hackacode.user.domain.User;

import java.util.List;

public class Client {
    private Long id;
    private User user;
    private Long userId;
    //TODO VER SI ES NECESARIO ESTE ATRIBUTO ACA
    private List<Sale> sales;

    public Client() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    private Client(User user) {
        this.user = user;
    }

    public static Client withUser(User user) {
        return new Client(user);
    }

    public void setId(Long id) {
        this.id = id;
    }
}
