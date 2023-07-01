package com.example.A1_ProductShop.repositories;

import com.example.A1_ProductShop.entities.Category;
import com.example.A1_ProductShop.entities.dto.category.CategoryByProductsSummaryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(nativeQuery = true, value = """
            SELECT *
            FROM categories
            ORDER BY RAND ()
            LIMIT 2
            """)
    Optional<Set<Category>> getRandomEntity();

    @Query("""
            SELECT NEW com.example.A1_ProductShop
            .entities.dto.category.CategoryByProductsSummaryDTO(c.name, COUNT(p.id), AVG(p.price), SUM(p.price))
            FROM Product AS p
            JOIN p.categories AS c
            GROUP BY c.id
            ORDER BY COUNT(p.id) DESC
                        """)
    Optional<List<CategoryByProductsSummaryDTO>> getCategoriesByProductSummary();
}
