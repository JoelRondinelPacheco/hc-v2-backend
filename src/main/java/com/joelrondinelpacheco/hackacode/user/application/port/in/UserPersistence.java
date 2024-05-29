package com.joelrondinelpacheco.hackacode.user.application.port.in;

import com.joelrondinelpacheco.hackacode.user.application.dto.NewEmployeeDTO;
import com.joelrondinelpacheco.hackacode.user.domain.UserBase;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface UserPersistence {
    UserBase newEmployee(NewEmployeeDTO employeeDTO) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException;
}
