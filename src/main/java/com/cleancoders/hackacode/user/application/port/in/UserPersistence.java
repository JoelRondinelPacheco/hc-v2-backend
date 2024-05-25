package com.cleancoders.hackacode.user.application.port.in;

import com.cleancoders.hackacode.user.application.dto.NewEmployeeDTO;
import com.cleancoders.hackacode.user.domain.User;
import com.cleancoders.hackacode.user.domain.UserBase;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface UserPersistence {
    UserBase newEmployee(NewEmployeeDTO employeeDTO) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException;
}
