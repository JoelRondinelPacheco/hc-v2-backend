package com.cleancoders.hackacode.security.application.port.out;

import com.cleancoders.hackacode.security.application.dto.operation.OperationDTO;
import com.cleancoders.hackacode.security.domain.Operation;

import java.util.List;

public interface OperationPersistencePort {
    Operation createOperation(OperationDTO operation);

    List<Operation> findByPublicAccess();
}
