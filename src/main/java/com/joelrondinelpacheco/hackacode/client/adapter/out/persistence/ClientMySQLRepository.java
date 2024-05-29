package com.joelrondinelpacheco.hackacode.client.adapter.out.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientMySQLRepository extends JpaRepository<ClientEntity, Long> {
    boolean existsByPerson_Email(String email);
    boolean existsByPerson_Id(Long userId);
    @Query("SELECT c FROM client c WHERE CONCAT(c.person.name, ' ', c.person.lastname) LIKE %:name%")
    Page<ClientEntity> byName(@Param("name") String name, Pageable pageable);


}
