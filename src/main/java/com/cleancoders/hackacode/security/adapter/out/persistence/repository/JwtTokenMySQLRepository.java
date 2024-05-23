package com.cleancoders.hackacode.security.adapter.out.persistence.repository;

import com.cleancoders.hackacode.security.adapter.out.persistence.entity.JwtTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface JwtTokenMySQLRepository extends JpaRepository<JwtTokenEntity, Long> {
    Optional<JwtTokenEntity> findByToken(String jwt);


    @Modifying
    @Transactional
    @Query("UPDATE JwtTokenEntity jwt SET jwt.isValid = :isValid WHERE jwt.token = :token")
    int invalidateToken(String token, boolean isValid);
}
