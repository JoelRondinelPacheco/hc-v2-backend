package com.joelrondinelpacheco.hackacode.users.application.port.in;

import com.joelrondinelpacheco.hackacode.employee.application.dto.NewEmployeeDTO;
import com.joelrondinelpacheco.hackacode.person.application.dto.NewPersonDTO;

public interface RegisterUserUseCase {
    String registerClient(NewPersonDTO body);
    String registerEmployee(NewEmployeeDTO body);
}
