package com.cleancoders.hackacode.employee.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.employee.application.port.in.EmployeeSelector;
import com.cleancoders.hackacode.employee.application.port.out.EmployeeSelectorPort;
import com.cleancoders.hackacode.employee.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UseCase
public class EmployeeSelectorImpl implements EmployeeSelector {

    @Autowired
    private EmployeeSelectorPort employeeSelector;

    @Override
    public Employee byId(Long id) {
        return this.employeeSelector.byId(id);
    }

    @Override
    public Employee byEmail(String email) {
        return this.employeeSelector.byEmail(email);
    }

    @Override
    public List<Employee> getAll() {
        return this.employeeSelector.getAll();
    }
}
