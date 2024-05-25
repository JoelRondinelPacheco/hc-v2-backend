package com.cleancoders.hackacode.security.application.port.out;

import com.cleancoders.hackacode.security.application.dto.module.ModuleDTO;
import com.cleancoders.hackacode.security.domain.Module;

public interface ModulePersistencePort {
    Module addModule(ModuleDTO body);
}
