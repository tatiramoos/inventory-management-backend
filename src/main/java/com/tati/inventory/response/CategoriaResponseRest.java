package com.tati.inventory.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaResponseRest extends ResponseRest{

    private CategoryResponse response = new CategoryResponse();
}
