package com.cleancoders.hackacode.employee.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.employee.application.port.out.EmployeeUtilsPort;
import org.springframework.beans.factory.annotation.Autowired;

@PersistenceAdapter
public class EmployeeUtilsPersistenceAdapter implements EmployeeUtilsPort {

    @Autowired
    private EmployeeMySQLRepository employeeMySQLRepository;
    @Override
    public boolean existsByUserId(Long id) {
        return this.employeeMySQLRepository.existsByUser_Id(id);
    }

    @Override
    public boolean existsByUserEmail(String email) {
        return this.employeeMySQLRepository.existsByUser_Email(email);
    }
}
