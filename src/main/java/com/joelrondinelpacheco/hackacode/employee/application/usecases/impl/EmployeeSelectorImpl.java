package com.joelrondinelpacheco.hackacode.employee.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.employee.application.port.in.EmployeeSelector;
import com.joelrondinelpacheco.hackacode.employee.application.port.out.EmployeeSelectorPort;
import com.joelrondinelpacheco.hackacode.employee.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
    public Page<Employee> getPage(Pageable pageable) {
        return this.employeeSelector.getPage(pageable);
    }
}
