package com.cleancoders.hackacode.security.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.security.application.port.in.OperationSelector;
import com.cleancoders.hackacode.security.application.port.out.OperationPersistencePort;
import com.cleancoders.hackacode.security.domain.Operation;
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
