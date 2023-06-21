package com.example.advquerying.services.ingredient;

import com.example.advquerying.entities.Ingredient;

import java.math.BigDecimal;
import java.util.List;

public interface IngredientService {

    List<Ingredient> findByNameStartingWith(String letters);

    List<Ingredient> findAllByNameInOrderByPrice(List<String> ingredients);

    void deleteIngredientByName(String ingredient);

   void updateAllIngredientsPrice();

    void updateIngredientsPriceByName(List<String> ingredients, BigDecimal percentage);
}
