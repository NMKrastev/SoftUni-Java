package com.example.sd11_exercisespringdataadvancedquerying.services.author;


import com.example.sd11_exercisespringdataadvancedquerying.models.Author;

import java.util.List;

public interface AuthorService {

    void seedAuthors(List<Author> authors);

    boolean isDataSeeded();

    Author getRandomAuthor();

    List<Author> findAuthorsByFirstNameEndsWith(String letters);
}
