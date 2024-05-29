package com.joelrondinelpacheco.hackacode.person.application.port.in;

import com.joelrondinelpacheco.hackacode.person.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonSelector {

    Page<Person> getAll(Pageable pageable);

}
