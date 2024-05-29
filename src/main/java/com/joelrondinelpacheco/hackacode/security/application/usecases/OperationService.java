package com.joelrondinelpacheco.hackacode.security.application.usecases;

import com.joelrondinelpacheco.hackacode.security.domain.Operation;

import java.util.List;

public interface OperationService {

    List<Operation> findByPublicAccess();
}
