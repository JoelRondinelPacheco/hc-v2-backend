package com.cleancoders.hackacode.service.application.port.out;

import com.cleancoders.hackacode.service.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategorySelectorPort {
    Page<Category> getPage(Pageable pageable);
}