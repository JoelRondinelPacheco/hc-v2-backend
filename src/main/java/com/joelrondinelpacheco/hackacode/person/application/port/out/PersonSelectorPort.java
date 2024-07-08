package com.joelrondinelpacheco.hackacode.person.application.port.out;

import com.joelrondinelpacheco.hackacode.person.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonSelectorPort {
    Person getById(Long id);
    Page<Person> getAll(Pageable pageable);
}
