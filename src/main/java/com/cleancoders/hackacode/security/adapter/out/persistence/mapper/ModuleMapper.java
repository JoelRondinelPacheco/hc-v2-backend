package com.cleancoders.hackacode.security.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.security.adapter.out.persistence.entity.ModuleEntity;
import com.cleancoders.hackacode.security.domain.Module;
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
