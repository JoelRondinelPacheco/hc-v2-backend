package com.joelrondinelpacheco.hackacode.security.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.security.application.dto.operation.OperationDTO;
import com.joelrondinelpacheco.hackacode.security.application.port.in.OperationPersistence;
import com.joelrondinelpacheco.hackacode.security.application.port.out.OperationPersistencePort;
import com.joelrondinelpacheco.hackacode.security.domain.Operation;
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
