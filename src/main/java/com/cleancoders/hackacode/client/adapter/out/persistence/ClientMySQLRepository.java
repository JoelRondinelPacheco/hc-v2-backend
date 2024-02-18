package com.cleancoders.hackacode.client.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientMySQLRepository extends JpaRepository<ClientEntity, Long> {
    boolean existsByUser_Email(String email);
}
