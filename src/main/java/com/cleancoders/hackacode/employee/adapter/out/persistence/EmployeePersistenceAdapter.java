package com.cleancoders.hackacode.employee.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.employee.application.port.out.EmployeePersistencePort;
import com.cleancoders.hackacode.employee.domain.Employee;

@PersistenceAdapter
public class EmployeePersistenceAdapter implements EmployeePersistencePort {
    @Override
    public Employee save(Employee employee) {
        return null;
    }
}
