package com.cleancoders.hackacode.user.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMySQLRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmail(String email);
}
