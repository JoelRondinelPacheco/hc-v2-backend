package com.joelrondinelpacheco.hackacode.employee.application.port.in;

import com.joelrondinelpacheco.hackacode.person.application.dto.NewClientDTO;

public interface RegisterEmployeeUseCase {
    void createEmployee(NewClientDTO body);
}
