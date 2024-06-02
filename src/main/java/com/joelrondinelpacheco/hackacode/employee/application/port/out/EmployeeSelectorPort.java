package com.joelrondinelpacheco.hackacode.employee.application.port.out;

import com.joelrondinelpacheco.hackacode.employee.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeSelectorPort {
    Employee byId(Long id);
    Employee byEmail(String email);

    Page<Employee> getPage(Pageable pageable);
}
