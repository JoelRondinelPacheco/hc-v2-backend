package com.cleancoders.hackacode.security.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.security.adapter.out.persistence.entity.ModuleEntity;
import com.cleancoders.hackacode.security.adapter.out.persistence.repository.ModuleMySQLRepository;
import com.cleancoders.hackacode.security.application.dto.module.ModuleDTO;
import com.cleancoders.hackacode.security.application.port.out.ModulePersistencePort;
import com.cleancoders.hackacode.security.application.port.out.ModuleSelectorPort;
import com.cleancoders.hackacode.security.domain.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@PersistenceAdapter
public class ModulePersistenceAdapter implements ModulePersistencePort, ModuleSelectorPort {

    @Autowired
    private ModuleMySQLRepository moduleMySQLRepository;
    @Autowired
    @Qualifier("moduleMapper")
    private Mapper<Module, ModuleEntity> mapper;

    @Override
    public Module addModule(ModuleDTO body) {
        return null;
    }

    @Override
    public Page<Module> getPage(Pageable pageable) {
        return null;
    }
}
