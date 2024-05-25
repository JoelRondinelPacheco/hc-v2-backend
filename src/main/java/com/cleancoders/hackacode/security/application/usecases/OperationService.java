package com.cleancoders.hackacode.security.application.usecases;

import com.cleancoders.hackacode.security.domain.Operation;

import java.util.List;

public interface OperationService {

    List<Operation> findByPublicAccess();
}
