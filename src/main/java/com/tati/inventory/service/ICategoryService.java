package com.tati.inventory.service;

import com.tati.inventory.response.CategoryResponseRest;
import org.springframework.http.ResponseEntity;

public interface ICategoryService {

    public ResponseEntity<CategoryResponseRest> findAll();
    public ResponseEntity<CategoryResponseRest> findById(Long id);
}
