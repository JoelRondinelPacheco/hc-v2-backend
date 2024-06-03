package com.joelrondinelpacheco.hackacode.employee.application.port.in;

import com.joelrondinelpacheco.hackacode.person.application.dto.NewPersonDTO;

public interface RegisterEmployeeUseCase {
    void createEmployee(NewPersonDTO body);
}
