package com.joelrondinelpacheco.hackacode.service.adapter.in.web;

import com.joelrondinelpacheco.hackacode.service.application.dto.NewCategoryDTO;
import com.joelrondinelpacheco.hackacode.service.application.port.in.CategoryPersistence;
import com.joelrondinelpacheco.hackacode.service.application.port.in.CategorySelector;
import com.joelrondinelpacheco.hackacode.service.application.port.in.ServiceSelector;
import com.joelrondinelpacheco.hackacode.service.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {


    private final ServiceSelector serviceSelector;
    private final CategoryPersistence categoryPersistence;
    private final CategorySelector categorySelector;

    public CategoryController(ServiceSelector serviceSelector, CategoryPersistence categoryPersistence, CategorySelector categorySelector) {
        this.serviceSelector = serviceSelector;
        this.categoryPersistence = categoryPersistence;
        this.categorySelector = categorySelector;
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody NewCategoryDTO body) {
        return ResponseEntity.ok(this.categoryPersistence.newCategory(body));
    }

    @GetMapping
    public ResponseEntity<Page<Category>> getAll(Pageable pageable) {
        Page<Category> categories = this.categorySelector.getPage(pageable);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{categoryId}")
    ResponseEntity<Category> getById(@PathVariable Long categoryId) {
        return ResponseEntity.ok(this.categorySelector.getById(categoryId));
    }

    @GetMapping("/services")
    public ResponseEntity<?> getAllWithServices(Pageable pageable) {
        //TODO IMPL
        return null;
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable int categoryId, @RequestBody Category category) {
        System.out.println("EDITO: Id " + categoryId + " id: " + category.getId() + " name: " + category.getName());
        Category categoryEdited = this.categoryPersistence.update(category);
        return ResponseEntity.ok(categoryEdited);
    }

}
