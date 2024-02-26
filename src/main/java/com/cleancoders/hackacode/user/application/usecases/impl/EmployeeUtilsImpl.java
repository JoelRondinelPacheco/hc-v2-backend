package com.cleancoders.hackacode.user.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.user.application.port.out.UserUtilsPort;
import com.cleancoders.hackacode.user.application.usecases.EmployeeUtils;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class EmployeeUtilsImpl implements EmployeeUtils {

    @Autowired
    private UserUtilsPort userUtilsPort;


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
        return "TOCORANDOMPASSWORD";
    }
}
