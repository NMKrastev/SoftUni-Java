package com.example.A1_BookshopSystem.services.book;

import com.example.A1_BookshopSystem.models.Author;
import com.example.A1_BookshopSystem.models.Book;

import java.time.LocalDate;
import java.util.List;

public interface BookService {

    void seedBooks(List<Book> books);

    boolean isDataSeeded();

    List<Book> findBooksByReleaseDateAfter(LocalDate date);

    List<Book> findAllByAuthorOrderByReleaseDateDescTitleAsc(Author author);
}
