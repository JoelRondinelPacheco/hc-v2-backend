package com.cleancoders.hackacode.user.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMySQLRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByUser_Email(String email);
    boolean existsByUser_Id(Long id);
}
