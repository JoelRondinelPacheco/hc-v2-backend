package com.cleancoders.hackacode.security.application.port.out;

import com.cleancoders.hackacode.security.domain.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OperationSelectorPort {
    Page<Operation> getPage(Pageable pageable);
}
