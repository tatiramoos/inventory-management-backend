package com.tati.inventory.service;

import com.tati.inventory.model.Category;
import com.tati.inventory.repository.ICategoryRepository;
import com.tati.inventory.response.CategoriaResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private ICategoryRepository repository;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoriaResponseRest> search() {
        CategoriaResponseRest response = new CategoriaResponseRest();

        try {
            List<Category> categoryList = (List<Category>) repository.findAll();
            response.getResponse().setCategory(categoryList);
            response.setMetadata("Resposta OK", "00", "Resposta exitosa" );
        } catch (Exception e) {
            response.setMetadata("Resposta nok", "-1", "Error al consultar");
            e.getStackTrace();
            return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK);
    }
}
