package com.example.advquerying.services.ingredient;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repositories.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class IngredientServiceImpl implements IngredientService {

    private IngredientsRepository ingredientsRepository;

    @Autowired
    public IngredientServiceImpl(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    @Override
    public List<Ingredient> findByNameStartingWith(String letters) {

        return this.ingredientsRepository.findByNameStartingWith(letters)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Ingredient> findAllByNameInOrderByPrice(List<String> ingredients) {

        return this.ingredientsRepository.findAllByNameInOrderByPrice(ingredients)
                .orElseThrow(NoSuchElementException::new);
    }
}
