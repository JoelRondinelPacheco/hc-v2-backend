package com.joelrondinelpacheco.hackacode.service.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.entity.CategoryEntity;
import com.joelrondinelpacheco.hackacode.service.application.port.out.CategorySelectorPort;

public interface CategorySelectorAdapter extends CategorySelectorPort {
    CategoryEntity getCategoryEntityById(Long id);
}
