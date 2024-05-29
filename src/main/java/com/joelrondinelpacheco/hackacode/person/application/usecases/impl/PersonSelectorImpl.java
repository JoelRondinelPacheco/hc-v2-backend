package com.joelrondinelpacheco.hackacode.person.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.person.application.port.in.PersonSelector;
import com.joelrondinelpacheco.hackacode.person.application.port.out.PersonSelectorPort;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
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
