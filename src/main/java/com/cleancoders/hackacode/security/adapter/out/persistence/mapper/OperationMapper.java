package com.cleancoders.hackacode.security.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.security.adapter.out.persistence.entity.OperationEntity;
import com.cleancoders.hackacode.security.domain.Operation;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceMapper
@Qualifier("operationMapper")
public class OperationMapper implements Mapper<Operation, OperationEntity> {
    @Override
    public Operation entityToDomain(OperationEntity operationEntity) {
        return null;
    }

    @Override
    public OperationEntity domainToEntity(Operation operation) {
        return null;
    }
}
