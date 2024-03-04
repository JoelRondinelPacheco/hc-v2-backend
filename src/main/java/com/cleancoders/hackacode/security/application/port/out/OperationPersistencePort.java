package com.cleancoders.hackacode.security.application.port.out;

import com.cleancoders.hackacode.security.application.dto.operation.OperationDTO;
import com.cleancoders.hackacode.security.domain.Operation;

public interface OperationPersistencePort {
    Operation createOperation(OperationDTO operation);
}
