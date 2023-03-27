package com.tati.inventory;

import com.tati.inventory.response.CategoriaResponseRest;
import com.tati.inventory.service.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    private ICategoryService service;

    @GetMapping("/categories")
    public ResponseEntity<CategoriaResponseRest> allCategories() {
        ResponseEntity<CategoriaResponseRest> response = service.search();
        return response;
    }

}
