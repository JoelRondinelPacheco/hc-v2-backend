package com.joelrondinelpacheco.hackacode.employee.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeMySQLRepository extends JpaRepository<EmployeeEntity, Long> {

    boolean existsByPerson_Email(String email);
    boolean existsByPerson_Id(Long id);

    Optional<EmployeeEntity> findByPerson_Email(String email);
}
