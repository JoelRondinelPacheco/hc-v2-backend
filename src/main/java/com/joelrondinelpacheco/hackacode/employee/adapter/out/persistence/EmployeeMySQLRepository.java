package com.joelrondinelpacheco.hackacode.employee.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeMySQLRepository extends JpaRepository<EmployeeEntity, Long> {

    boolean existsByPerson_Email(String email);
    boolean existsByPerson_Id(Long id);
}
