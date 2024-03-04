package com.cleancoders.hackacode.security.application.port.in;

import com.cleancoders.hackacode.security.domain.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OperationSelector {
    Page<Operation> getPage(Pageable pageable);
}
