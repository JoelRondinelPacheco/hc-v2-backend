package com.joelrondinelpacheco.hackacode.employee.application.port.out;

public interface EmployeeUtilsPort {
    boolean existsByEmployeeId(Long id);
    boolean existsByEmployeeEmail(String email);

    boolean existsById(Long id);
}
