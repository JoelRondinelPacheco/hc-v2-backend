package com.cleancoders.hackacode.person.application.port.out;

import com.cleancoders.hackacode.person.application.dto.PersonInfoDTO;
import com.cleancoders.hackacode.person.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonSelectorPort {
    Page<Person> getAll(Pageable pageable);
}
