package com.cleancoders.hackacode.person.application.port.in;

import com.cleancoders.hackacode.person.application.dto.PersonInfoDTO;
import com.cleancoders.hackacode.person.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonSelector {

    Page<Person> getAll(Pageable pageable);

}
