package com.example.A1_BookshopSystem.repositories;

import com.example.A1_BookshopSystem.models.Author;
import com.example.A1_BookshopSystem.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<List<Book>> findBooksByReleaseDateAfter(LocalDate date);

    Optional<List<Book>> findAllByAuthorOrderByReleaseDateDescTitleAsc(Author author);

}
