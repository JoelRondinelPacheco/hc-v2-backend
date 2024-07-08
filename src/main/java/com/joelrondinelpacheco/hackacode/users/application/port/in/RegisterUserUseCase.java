package com.joelrondinelpacheco.hackacode.users.application.port.in;

import com.joelrondinelpacheco.hackacode.employee.application.dto.NewEmployeeDTO;
import com.joelrondinelpacheco.hackacode.person.application.dto.NewClientDTO;

public interface RegisterUserUseCase {
    String registerClient(NewClientDTO body);
    String registerEmployee(NewEmployeeDTO body);
}
