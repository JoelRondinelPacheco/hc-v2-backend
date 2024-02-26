package com.cleancoders.hackacode.client.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientMySQLRepository extends JpaRepository<ClientEntity, Long> {
    boolean existsByPerson_Email(String email);
    boolean existsByPerson_Id(Long userId);
}
