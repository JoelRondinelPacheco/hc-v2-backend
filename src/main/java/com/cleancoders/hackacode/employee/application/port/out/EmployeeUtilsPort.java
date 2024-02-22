package com.cleancoders.hackacode.employee.application.port.out;

public interface EmployeeUtilsPort {
    boolean existsByUserId(Long id);
    boolean existsByUserEmail(String email);
}
