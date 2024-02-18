package com.cleancoders.hackacode.client.adapter.out.persistence;

import com.cleancoders.hackacode.user.adapter.out.persistence.UserEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
