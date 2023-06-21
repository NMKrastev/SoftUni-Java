package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredient, Long> {

    Optional<List<Ingredient>> findByNameStartingWith(String letters);

    Optional<List<Ingredient>> findAllByNameInOrderByPrice(List<String> ingredients);

    void deleteByName(String ingredient);

    @Query(nativeQuery = true, value = "UPDATE ingredients AS i SET i.price = i.price * 1.10")
    @Modifying
    void updateAllIngredientsPrice();

    @Query("UPDATE Ingredient AS i SET i.price = i.price * ?2 WHERE i.name IN ?1")
    @Modifying
    void updateIngredientsPriceByName(List<String> ingredients, BigDecimal percentage);
}
