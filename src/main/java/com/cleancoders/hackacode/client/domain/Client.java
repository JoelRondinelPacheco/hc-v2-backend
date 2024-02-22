package com.cleancoders.hackacode.client.domain;

import com.cleancoders.hackacode.sale.domain.Sale;
import com.cleancoders.hackacode.user.domain.User;

import java.util.List;

public class Client {
    private Long id;
    private User user;

    public Client() {
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

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
