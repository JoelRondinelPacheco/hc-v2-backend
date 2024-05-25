package com.cleancoders.hackacode.person.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.person.application.port.in.PersonSelector;
import com.cleancoders.hackacode.person.application.port.out.PersonSelectorPort;
import com.cleancoders.hackacode.person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@UseCase
public class PersonSelectorImpl implements PersonSelector {

    @Autowired
    private PersonSelectorPort personSelectorPort;

    @Override
    public Page<Person> getAll(Pageable pageable) {
        return this.personSelectorPort.getAll(pageable);
    }
}
