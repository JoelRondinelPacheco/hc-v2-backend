package com.joelrondinelpacheco.hackacode.service.application.port.in;

import com.joelrondinelpacheco.hackacode.service.domain.Category;
import com.joelrondinelpacheco.hackacode.service.domain.CategoryInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategorySelector {

    Page<Category> getPage(Pageable pageable);
    Page<CategoryInfo> getAllWithServices(Pageable pageable);
    Category getById(Long categoryId);
}
