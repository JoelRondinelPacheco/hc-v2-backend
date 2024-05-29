package com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.mapper;

import com.joelrondinelpacheco.hackacode.common.PersistenceMapper;
import com.joelrondinelpacheco.hackacode.common.adapter.Mapper;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity.ModuleEntity;
import com.joelrondinelpacheco.hackacode.security.domain.Module;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceMapper
@Qualifier("moduleMapper")
public class ModuleMapper implements Mapper<Module, ModuleEntity> {
    @Override
    public Module entityToDomain(ModuleEntity moduleEntity) {
        return Module.builder()
                .id(moduleEntity.getId())
                .name(moduleEntity.getName())
                .basePath(moduleEntity.getBasePath())
                .build();
    }

    @Override
    public ModuleEntity domainToEntity(Module module) {
        return ModuleEntity.builder()
                .name(module.getName())
                .basePath(module.getBasePath())
                .build();
    }
}
