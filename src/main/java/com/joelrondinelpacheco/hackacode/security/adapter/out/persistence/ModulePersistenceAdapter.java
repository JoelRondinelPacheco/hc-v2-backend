package com.joelrondinelpacheco.hackacode.security.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.common.adapter.Mapper;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity.ModuleEntity;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.repository.ModuleMySQLRepository;
import com.joelrondinelpacheco.hackacode.security.application.dto.module.ModuleDTO;
import com.joelrondinelpacheco.hackacode.security.application.port.out.ModulePersistencePort;
import com.joelrondinelpacheco.hackacode.security.application.port.out.ModuleSelectorPort;
import com.joelrondinelpacheco.hackacode.security.domain.Module;
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
