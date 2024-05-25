package com.cleancoders.hackacode.security.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.security.application.port.out.OperationPersistencePort;
import com.cleancoders.hackacode.security.application.usecases.OperationService;
import com.cleancoders.hackacode.security.domain.Operation;
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
