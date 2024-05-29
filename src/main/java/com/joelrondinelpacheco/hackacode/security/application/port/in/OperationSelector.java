package com.joelrondinelpacheco.hackacode.security.application.port.in;

import com.joelrondinelpacheco.hackacode.security.domain.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OperationSelector {
    Page<Operation> getPage(Pageable pageable);
}
