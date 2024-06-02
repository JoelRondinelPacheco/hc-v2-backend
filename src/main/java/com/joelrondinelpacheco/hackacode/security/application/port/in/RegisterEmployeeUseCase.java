package com.joelrondinelpacheco.hackacode.security.application.port.in;

import com.joelrondinelpacheco.hackacode.person.application.dto.NewPersonDTO;

public interface RegisterEmployeeUseCase {
    void createEmployee(NewPersonDTO body);
}
