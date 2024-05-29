package com.joelrondinelpacheco.hackacode.person.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonMySQLRepository extends JpaRepository<PersonEntity, Long> {
    boolean existsByEmail(String email);
}
