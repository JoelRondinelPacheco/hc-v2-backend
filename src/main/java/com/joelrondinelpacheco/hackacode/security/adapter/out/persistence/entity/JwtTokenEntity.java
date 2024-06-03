package com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class JwtTokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2048)
    private String token;
    private Date expiration;
    private boolean isValid;
/*
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private EmployeeEntity userEntity;*/
}
