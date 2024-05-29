package com.joelrondinelpacheco.hackacode.security.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.security.application.port.in.OperationSelector;
import com.joelrondinelpacheco.hackacode.security.application.port.out.OperationPersistencePort;
import com.joelrondinelpacheco.hackacode.security.domain.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@UseCase
public class OperationSelectorImpl implements OperationSelector {

    @Autowired
    private OperationPersistencePort operationPersistencePort;

    @Override
    public Page<Operation> getPage(Pageable pageable) {
        return null;
    }
}
