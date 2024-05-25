package com.cleancoders.hackacode.security.application.port.in;

import com.cleancoders.hackacode.security.application.dto.operation.OperationDTO;
import com.cleancoders.hackacode.security.domain.Operation;

public interface OperationPersistence {
    Operation createOperation(OperationDTO operation);
}
