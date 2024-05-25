package com.cleancoders.hackacode.user.adapter.out.persistence;

import com.cleancoders.hackacode.person.adapter.out.persistence.PersonEntity;
import com.cleancoders.hackacode.security.adapter.out.persistence.entity.JwtTokenEntity;
import com.cleancoders.hackacode.security.domain.JwtToken;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "user_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private PersonEntity person;

    private BigDecimal salary;
    private String password;

}
