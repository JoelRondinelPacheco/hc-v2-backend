package com.cleancoders.hackacode.security.adapter.out.persistence.entity;

import com.cleancoders.hackacode.user.adapter.out.persistence.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "jwt_token")
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
    private LocalDate expiration;
    private boolean isValid;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}
