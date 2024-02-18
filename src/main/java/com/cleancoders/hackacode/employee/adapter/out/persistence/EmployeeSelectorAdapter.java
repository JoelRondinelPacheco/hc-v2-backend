package com.cleancoders.hackacode.employee.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.employee.application.port.out.EmployeeSelectorPort;
import com.cleancoders.hackacode.employee.domain.Employee;

@PersistenceAdapter
public class EmployeeSelectorAdapter implements EmployeeSelectorPort {
    @Override
    public Employee byId(Long id) {
        return null;
    }

    @Override
    public Employee byEmail(String email) {
        return null;
    }
}
