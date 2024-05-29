package com.joelrondinelpacheco.hackacode.security.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.security.application.dto.module.ModuleDTO;
import com.joelrondinelpacheco.hackacode.security.application.port.in.ModulePersistence;
import com.joelrondinelpacheco.hackacode.security.application.port.out.ModulePersistencePort;
import com.joelrondinelpacheco.hackacode.security.domain.Module;
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
