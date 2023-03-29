package com.tati.inventory.service;

import com.tati.inventory.model.Category;
import com.tati.inventory.response.CategoryResponseRest;
import org.springframework.http.ResponseEntity;

public interface ICategoryService {

    ResponseEntity<CategoryResponseRest> findAll();
    ResponseEntity<CategoryResponseRest> findById(Long id);
    ResponseEntity<CategoryResponseRest> save(Category category);
    ResponseEntity<CategoryResponseRest> update(Category category, Long id);
    ResponseEntity <CategoryResponseRest> deleteById(Long id);
}
