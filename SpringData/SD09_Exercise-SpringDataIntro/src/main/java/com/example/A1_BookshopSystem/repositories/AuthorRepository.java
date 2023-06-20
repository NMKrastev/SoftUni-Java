package com.example.A1_BookshopSystem.repositories;

import com.example.A1_BookshopSystem.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findAuthorById(Long id);

    Optional<Author> findAuthorByFirstNameAndLastName(String firstName, String lastName);

    @Query(value = "FROM Author AS a LEFT JOIN Book AS b ON a.id = b.author.id "
            + "WHERE a.id IN (SELECT DISTINCT b2.author.id FROM Book AS b2) AND b.releaseDate < ?1")
    Optional<List<Author>> findAllByBooksReleaseDateBefore(LocalDate date);

    @Query(value = "SELECT a, COUNT(b.author.id) AS book_count FROM Author AS a " +
            "JOIN Book b ON a.id = b.author.id " +
            "GROUP BY b.author.id " +
            "ORDER BY COUNT(b.author.id) DESC")
    Optional<List<Object[]>> findAllAuthorsByNumberOfTheirBooks();

}
