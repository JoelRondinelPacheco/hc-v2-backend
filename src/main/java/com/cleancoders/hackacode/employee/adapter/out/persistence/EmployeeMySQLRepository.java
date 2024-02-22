package com.cleancoders.hackacode.employee.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeMySQLRepository extends JpaRepository<EmployeeEntity, Long> {

    boolean existsByUser_Email(String email);
    boolean existsByUser_Id(Long id);
}
