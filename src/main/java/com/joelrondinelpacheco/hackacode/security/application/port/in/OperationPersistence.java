package com.joelrondinelpacheco.hackacode.security.application.port.in;

import com.joelrondinelpacheco.hackacode.security.application.dto.operation.OperationDTO;
import com.joelrondinelpacheco.hackacode.security.domain.Operation;

public interface OperationPersistence {
    Operation createOperation(OperationDTO operation);
}
