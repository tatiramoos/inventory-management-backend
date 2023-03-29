package com.tati.inventory.controller;

import com.tati.inventory.response.CategoryResponseRest;
import com.tati.inventory.service.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
