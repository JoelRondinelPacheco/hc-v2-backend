package com.joelrondinelpacheco.hackacode.person.application.port.in;

import com.joelrondinelpacheco.hackacode.employee.application.dto.NewEmployeeDTO;
import com.joelrondinelpacheco.hackacode.person.application.dto.NewClientDTO;
import com.joelrondinelpacheco.hackacode.person.application.dto.PersonBaseDTO;
import com.joelrondinelpacheco.hackacode.person.domain.Person;

public interface PersonPersistence {

    Person create(NewClientDTO personDTO);
    Person createStarterPersonEntity(PersonBaseDTO personDTO);
    Person personForNewEmployeeFromAdmin(NewEmployeeDTO dto);
    Person save(Person person);
    Person update(Person person);
    String delete(Long userId);
}
