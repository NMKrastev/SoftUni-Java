package com.example.sd11_exercisespringdataadvancedquerying.repositories;

import com.example.sd11_exercisespringdataadvancedquerying.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findAuthorById(Long id);

    Optional<List<Author>> findAuthorsByFirstNameEndsWith(String letters);

}
