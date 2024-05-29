package com.joelrondinelpacheco.hackacode.security.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.security.application.port.out.OperationPersistencePort;
import com.joelrondinelpacheco.hackacode.security.application.usecases.OperationService;
import com.joelrondinelpacheco.hackacode.security.domain.Operation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UseCase
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationPersistencePort operationPersistencePort;

    @Override
    public List<Operation> findByPublicAccess() {
        return this.operationPersistencePort.findByPublicAccess();
    }
}
