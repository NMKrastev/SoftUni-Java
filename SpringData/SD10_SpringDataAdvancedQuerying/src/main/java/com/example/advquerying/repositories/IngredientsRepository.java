package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredient, Long> {

    Optional<List<Ingredient>> findByNameStartingWith(String letters);

    Optional<List<Ingredient>> findAllByNameInOrderByPrice(List<String> ingredients);
}
