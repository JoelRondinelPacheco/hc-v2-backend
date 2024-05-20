package com.cleancoders.hackacode.security.adapter.out.persistence.repository;

import com.cleancoders.hackacode.security.adapter.out.persistence.entity.JwtTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JwtTokenMySQLRepository extends JpaRepository<JwtTokenEntity, Long> {
    Optional<JwtTokenEntity> findByToken(String jwt);
}
