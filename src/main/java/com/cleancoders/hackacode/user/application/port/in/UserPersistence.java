package com.cleancoders.hackacode.user.application.port.in;

import com.cleancoders.hackacode.user.application.dto.NewEmployeeDTO;
import com.cleancoders.hackacode.user.domain.User;
import com.cleancoders.hackacode.user.domain.UserBase;

public interface UserPersistence {
    UserBase newEmployee(NewEmployeeDTO employeeDTO);
}
