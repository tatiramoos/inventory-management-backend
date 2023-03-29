package com.tati.inventory.controller;

import com.tati.inventory.model.Category;
import com.tati.inventory.response.CategoryResponseRest;
import com.tati.inventory.service.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {


    private final ICategoryService service;

    public CategoryController(ICategoryService service) {
        this.service = service;
    }

    @GetMapping("/categories")
    public ResponseEntity<CategoryResponseRest> allCategories() {
        return service.findAll();
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> categoriesById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/categories")
    public ResponseEntity<CategoryResponseRest> save(@RequestBody Category category) {
        return service.save(category);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> update(@RequestBody Category category, @PathVariable Long id) {
        return service.update(category, id);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> delete(@PathVariable Long id) {
        return service.deleteById(id);
    }
}
