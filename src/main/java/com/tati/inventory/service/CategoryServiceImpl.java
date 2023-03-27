package com.tati.inventory.service;

import com.tati.inventory.response.CategoriaResponseRest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements ICategoryService{

    @Override
    public ResponseEntity<CategoriaResponseRest> search() {
        return null;
    }
}
