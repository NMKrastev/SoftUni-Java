package com.example.advquerying.services.ingredient;

import com.example.advquerying.entities.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientService {

    List<Ingredient> findByNameStartingWith(String letters);

    List<Ingredient> findAllByNameInOrderByPrice(List<String> ingredients);

}
