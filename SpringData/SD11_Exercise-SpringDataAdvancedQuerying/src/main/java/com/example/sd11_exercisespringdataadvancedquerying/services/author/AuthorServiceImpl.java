package com.example.sd11_exercisespringdataadvancedquerying.services.author;

import com.example.sd11_exercisespringdataadvancedquerying.models.Author;
import com.example.sd11_exercisespringdataadvancedquerying.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

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
    public List<Author> findAuthorsByFirstNameEndsWith(String letters) {

        return this.authorRepository.findAuthorsByFirstNameEndsWith(letters)
                .orElseThrow(NoSuchElementException::new);
    }
}
