package com.joelrondinelpacheco.hackacode.users.application.usecases;

import com.joelrondinelpacheco.hackacode.person.application.dto.NewPersonDTO;
import com.joelrondinelpacheco.hackacode.users.application.dto.UserStarterDTO;

public interface UserStarterUseCase {
    UserStarterDTO createUserStarter(NewPersonDTO body);
}
