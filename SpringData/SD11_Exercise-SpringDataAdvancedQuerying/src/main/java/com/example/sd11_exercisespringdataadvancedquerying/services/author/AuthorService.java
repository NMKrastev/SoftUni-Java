package com.example.sd11_exercisespringdataadvancedquerying.services.author;


import com.example.sd11_exercisespringdataadvancedquerying.models.Author;

import java.time.LocalDate;
import java.util.List;

public interface AuthorService {

    void seedAuthors(List<Author> authors);

    boolean isDataSeeded();

    Author getRandomAuthor();

    Author findAuthorByFirstNameAndLastName(String firstName, String lastName);

    List<Author> findAllByBooksReleaseDateBefore(LocalDate date);

    List<Object[]> findAllAuthorsByNumberOfTheirBooks();

    List<Author> findAuthorsByFirstNameEndsWith(String letters);
}
