package com.joelrondinelpacheco.hackacode.security.application.port.out;

import com.joelrondinelpacheco.hackacode.security.application.dto.module.ModuleDTO;
import com.joelrondinelpacheco.hackacode.security.domain.Module;

public interface ModulePersistencePort {
    Module addModule(ModuleDTO body);
}
