package com.cleancoders.hackacode.service.application.port.in;

import com.cleancoders.hackacode.service.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategorySelector {

    Page<Category> getPage(Pageable pageable);
}
