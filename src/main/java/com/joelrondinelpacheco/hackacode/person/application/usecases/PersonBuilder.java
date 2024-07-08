package com.joelrondinelpacheco.hackacode.person.application.usecases;

import com.joelrondinelpacheco.hackacode.person.application.dto.NewClientDTO;
import com.joelrondinelpacheco.hackacode.person.domain.Person;

public interface PersonBuilder {
    Person userFromDTO(NewClientDTO userDTO);

}
