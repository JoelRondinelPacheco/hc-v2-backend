package com.cleancoders.hackacode.security.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.security.application.dto.module.ModuleDTO;
import com.cleancoders.hackacode.security.application.port.in.ModulePersistence;
import com.cleancoders.hackacode.security.application.port.out.ModulePersistencePort;
import com.cleancoders.hackacode.security.domain.Module;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class ModulePersistenceImpl implements ModulePersistence {

    @Autowired
    private ModulePersistencePort modulePersistencePort;

    @Override
    public Module addModule(ModuleDTO body) {
        return null;
    }
}
