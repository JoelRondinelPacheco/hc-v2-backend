package com.cleancoders.hackacode.security.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.security.adapter.out.persistence.entity.ModuleEntity;
import com.cleancoders.hackacode.security.adapter.out.persistence.entity.OperationEntity;
import com.cleancoders.hackacode.security.domain.Module;
import com.cleancoders.hackacode.security.domain.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceMapper
@Qualifier("operationMapper")
public class OperationMapper implements Mapper<Operation, OperationEntity> {

    @Autowired
    @Qualifier("moduleMapper")
    private Mapper<Module, ModuleEntity> moduleMapper;

    @Override
    public Operation entityToDomain(OperationEntity operationEntity) {
        return Operation.builder()
                .id(operationEntity.getId())
                .name(operationEntity.getName())
                .path(operationEntity.getPath())
                .httpMethod(operationEntity.getHttpMethod())
                .permitAll(operationEntity.isPermitAll())
                .module(this.moduleMapper.entityToDomain(operationEntity.getModule()))
                .build();
    }

    @Override
    public OperationEntity domainToEntity(Operation operation) {
        return OperationEntity.builder()
                .name(operation.getName())
                .path(operation.getPath())
                .httpMethod(operation.getHttpMethod())
                .permitAll(operation.isPermitAll())
                .build();
    }
}
