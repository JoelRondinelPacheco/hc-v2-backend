package com.cleancoders.hackacode.user.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMySQLRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByPerson_Email(String email);
    boolean existsByPerson_Id(Long id);
}
