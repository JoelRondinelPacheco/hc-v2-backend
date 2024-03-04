package com.cleancoders.hackacode.service.adapter.in.web;

import com.cleancoders.hackacode.service.application.dto.NewCategoryDTO;
import com.cleancoders.hackacode.service.application.port.in.CategoryPersistence;
import com.cleancoders.hackacode.service.application.port.in.CategorySelector;
import com.cleancoders.hackacode.service.application.port.in.ServiceSelector;
import com.cleancoders.hackacode.service.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ServiceSelector serviceSelector;
    @Autowired
    private CategoryPersistence categoryPersistence;
    @Autowired
    private CategorySelector categorySelector;

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody NewCategoryDTO body) {
        return ResponseEntity.ok(this.categoryPersistence.newCategory(body));
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll(Pageable pageable) {
        Page<Category> categories = this.categorySelector.getPage(pageable);
        return ResponseEntity.ok(categories.stream().toList());
    }

    @GetMapping("/services")
    public ResponseEntity<?> getAllWithServices(Pageable pageable) {
        //TODO IMPL
        return null;
    }

    /*
    TODO
        GET ALL WITH SERVICES
        BY ID / BY ID WITH SERVICES
        BY NAME / BY NAME WITH SERVICES
        EDIT CATEGORY
        DELETE CATEGORY - DISABLE

     */

}
