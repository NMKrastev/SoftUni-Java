package com.example.sd11_exercisespringdataadvancedquerying.repositories;

import com.example.sd11_exercisespringdataadvancedquerying.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findCategoryById(Long id);
}
