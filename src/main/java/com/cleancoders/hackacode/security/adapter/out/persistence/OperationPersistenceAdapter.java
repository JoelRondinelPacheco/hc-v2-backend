package com.cleancoders.hackacode.security.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.security.adapter.out.persistence.entity.OperationEntity;
import com.cleancoders.hackacode.security.adapter.out.persistence.repository.OperationMySQLRepository;
import com.cleancoders.hackacode.security.application.dto.operation.OperationDTO;
import com.cleancoders.hackacode.security.application.port.out.OperationPersistencePort;
import com.cleancoders.hackacode.security.application.port.out.OperationSelectorPort;
import com.cleancoders.hackacode.security.domain.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;


@PersistenceAdapter
public class OperationPersistenceAdapter implements OperationPersistencePort, OperationSelectorPort {

    @Autowired
    private OperationMySQLRepository operationMySQLRepository;
    @Autowired
    @Qualifier("operationMapper")
    private Mapper<Operation, OperationEntity> mapper;

    @Override
    public Operation createOperation(OperationDTO operation) {
        return null;
    }

    @Override
    public List<Operation> findByPublicAccess() {
        return this.operationMySQLRepository.findByPermitAll(true).stream().map(mapper::entityToDomain).collect(Collectors.toList());
    }

    @Override
    public Page<Operation> getPage(Pageable pageable) {
        return null;
    }
}
