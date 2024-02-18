package com.cleancoders.hackacode.client.adapter.out.persistence;

import com.cleancoders.hackacode.sale.adapter.out.persistence.SaleEntity;
import com.cleancoders.hackacode.user.adapter.out.persistence.UserEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity(name = "client")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @OneToMany
    private List<SaleEntity> sales;

    public Long getId() {
        return id;
    }

    public UserEntity getUser() {
        return user;
    }
}
