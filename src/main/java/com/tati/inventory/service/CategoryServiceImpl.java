package com.tati.inventory.service;

import com.tati.inventory.model.Category;
import com.tati.inventory.repository.ICategoryRepository;
import com.tati.inventory.response.CategoryResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private ICategoryRepository repository;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> findAll() {

        CategoryResponseRest response = new CategoryResponseRest();

        try {
            List<Category> categoryList = repository.findAll();
            response.getCategoryResponse().setCategory(categoryList);
            response.setMetadata("Resposta OK", "00", "Resposta exitosa" );

        } catch (Exception e) {
            response.setMetadata("Resposta nok", "-1", "Error al consultar");
            e.getStackTrace();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> findById(Long id) {
        CategoryResponseRest response = new CategoryResponseRest();
        List<Category> list = new ArrayList<>();

        try {
            Optional<Category> category = repository.findById(id);
            if (category.isPresent()) {
                list.add(category.get());
                response.getCategoryResponse().setCategory(list);
                response.setMetadata("Resposta ok", "00", "Categoria encontrada");
            } else {
                response.setMetadata("Resposta nok", "-1", "Categoria não encontrada");
                return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMetadata("Resposta nok", "-1", "Error querying by id");
            e.getStackTrace();
            return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
    }
}
