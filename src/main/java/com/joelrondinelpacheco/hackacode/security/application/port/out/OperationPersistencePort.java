package com.joelrondinelpacheco.hackacode.security.application.port.out;

import com.joelrondinelpacheco.hackacode.security.application.dto.operation.OperationDTO;
import com.joelrondinelpacheco.hackacode.security.domain.Operation;

import java.util.List;

public interface OperationPersistencePort {
    Operation createOperation(OperationDTO operation);

    List<Operation> findByPublicAccess();
}
