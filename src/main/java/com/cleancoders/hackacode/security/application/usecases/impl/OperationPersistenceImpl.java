package com.cleancoders.hackacode.security.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.security.application.dto.operation.OperationDTO;
import com.cleancoders.hackacode.security.application.port.in.OperationPersistence;
import com.cleancoders.hackacode.security.application.port.out.OperationPersistencePort;
import com.cleancoders.hackacode.security.domain.Operation;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class OperationPersistenceImpl implements OperationPersistence {

    @Autowired
    private OperationPersistencePort operationPersistencePort;

    @Override
    public Operation createOperation(OperationDTO operation) {
        return null;
    }
}
