package com.cleancoders.hackacode.security.application.port.in;

import com.cleancoders.hackacode.security.application.dto.module.ModuleDTO;
import com.cleancoders.hackacode.security.domain.Module;

public interface ModulePersistence {
    Module addModule(ModuleDTO body);
}
