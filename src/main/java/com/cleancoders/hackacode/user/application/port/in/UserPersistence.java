package com.cleancoders.hackacode.user.application.port.in;

import com.cleancoders.hackacode.user.application.dto.NewEmployeeDTO;
import com.cleancoders.hackacode.user.domain.User;

public interface UserPersistence {
    User newEmployee(NewEmployeeDTO employeeDTO);
}
