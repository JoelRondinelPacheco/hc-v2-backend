package com.joelrondinelpacheco.hackacode.security.application.port.in;

import com.joelrondinelpacheco.hackacode.security.application.dto.module.ModuleDTO;
import com.joelrondinelpacheco.hackacode.security.domain.Module;

public interface ModulePersistence {
    Module addModule(ModuleDTO body);
}
