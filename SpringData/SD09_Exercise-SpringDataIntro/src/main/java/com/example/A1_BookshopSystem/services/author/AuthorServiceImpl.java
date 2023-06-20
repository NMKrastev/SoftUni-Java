package com.example.A1_BookshopSystem.services.author;

import com.example.A1_BookshopSystem.models.Author;
import com.example.A1_BookshopSystem.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors(List<Author> authors) {

        this.authorRepository.saveAll(authors);
    }

    @Override
    public boolean isDataSeeded() {
        return this.authorRepository.count() > 0;
    }

    @Override
    public Author getRandomAuthor() {

        final long count = this.authorRepository.count();

        if (count != 0) {

            final long randomId = new Random().nextLong(1L, count) + 1L;

            return this.authorRepository.findAuthorById(randomId).orElseThrow(NoSuchElementException::new);
        }

        throw new RuntimeException("Authors table is empty!");

    }

    @Override
    public Author findAuthorByFirstNameAndLastName(String firstName, String lastName) {

        return this.authorRepository.findAuthorByFirstNameAndLastName(firstName, lastName)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Author> findAllByBooksReleaseDateBefore(LocalDate date) {

        return this.authorRepository.findAllByBooksReleaseDateBefore(date)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Object[]> findAllAuthorsByNumberOfTheirBooks() {

        return this.authorRepository.findAllAuthorsByNumberOfTheirBooks()
                .orElseThrow(NoSuchElementException::new);
    }
}
