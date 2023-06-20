package com.example.A1_BookshopSystem.services.book;

import com.example.A1_BookshopSystem.models.Author;
import com.example.A1_BookshopSystem.models.Book;
import com.example.A1_BookshopSystem.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void seedBooks(List<Book> books) {
        this.bookRepository.saveAll(books);
    }

    @Override
    public boolean isDataSeeded() {
        return this.bookRepository.count() > 0;
    }

    @Override
    public List<Book> findBooksByReleaseDateAfter(LocalDate date) {

        return this.bookRepository.findBooksByReleaseDateAfter(date)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> findAllByAuthorOrderByReleaseDateDescTitleAsc(Author author) {

        return this.bookRepository.findAllByAuthorOrderByReleaseDateDescTitleAsc(author)
                .orElseThrow(NoSuchElementException::new);
    }

}
