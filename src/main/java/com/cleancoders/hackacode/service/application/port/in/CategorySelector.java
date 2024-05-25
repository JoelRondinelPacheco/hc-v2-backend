package com.cleancoders.hackacode.service.application.port.in;

import com.cleancoders.hackacode.service.domain.Category;
import com.cleancoders.hackacode.service.domain.CategoryInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface CategorySelector {

    Page<Category> getPage(Pageable pageable);

    Page<CategoryInfo> getAllWithServices(Pageable pageable);
}
