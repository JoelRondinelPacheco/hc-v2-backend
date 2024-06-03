package com.joelrondinelpacheco.hackacode.employee.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.employee.application.port.out.EmployeeUtilsPort;
import com.joelrondinelpacheco.hackacode.employee.application.usecases.EmployeeUtils;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class EmployeeUtilsImpl implements EmployeeUtils {

    @Autowired
    private EmployeeUtilsPort employeeUtilsPort;


    @Override
    public void assertExistsByUserEmail(String userEmail) {

    }

    @Override
    public void assertDoesNotExistsByUserEmail(String userEmail) {

    }

    @Override
    public void assertExistsByUserId(Long userId) {

    }

    @Override
    public void assertDoesNotExistsByUserId(Long userId) {

    }

    @Override
    public void assertExistsById(Long userId) {

    }

    @Override
    public void assertDoesNotExistsById(Long userId) {

    }

    @Override
    public String createRandomPassword() {
        return "password";
    }
}
