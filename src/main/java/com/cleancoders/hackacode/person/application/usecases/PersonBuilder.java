package com.cleancoders.hackacode.person.application.usecases;

import com.cleancoders.hackacode.person.application.dto.NewPersonDTO;
import com.cleancoders.hackacode.person.domain.Person;

public interface PersonBuilder {
    Person userFromDTO(NewPersonDTO userDTO);
}
