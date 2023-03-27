package com.tati.inventory.service;

import com.tati.inventory.response.CategoriaResponseRest;
import org.springframework.http.ResponseEntity;

public interface ICategoryService {

    public ResponseEntity<CategoriaResponseRest> search();
}
