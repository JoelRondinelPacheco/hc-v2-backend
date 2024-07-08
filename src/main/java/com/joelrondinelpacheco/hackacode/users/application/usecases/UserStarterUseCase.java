package com.joelrondinelpacheco.hackacode.users.application.usecases;

import com.joelrondinelpacheco.hackacode.employee.application.dto.NewEmployeeDTO;
import com.joelrondinelpacheco.hackacode.person.application.dto.NewClientDTO;
import com.joelrondinelpacheco.hackacode.person.application.dto.PersonBaseDTO;
import com.joelrondinelpacheco.hackacode.users.application.dto.UserStarterDTO;

public interface UserStarterUseCase {

    UserStarterDTO createPersonStarterFromAdmin(PersonBaseDTO person, Long roleId);
}
