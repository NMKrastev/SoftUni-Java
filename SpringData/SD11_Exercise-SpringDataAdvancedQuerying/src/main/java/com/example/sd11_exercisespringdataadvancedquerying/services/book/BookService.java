package com.example.sd11_exercisespringdataadvancedquerying.services.book;


import com.example.sd11_exercisespringdataadvancedquerying.models.Author;
import com.example.sd11_exercisespringdataadvancedquerying.models.Book;

import java.time.LocalDate;
import java.util.List;

public interface BookService {

    void seedBooks(List<Book> books);

    boolean isDataSeeded();

    List<Book> findBooksByReleaseDateAfter(LocalDate date);

    List<Book> findAllByAuthorOrderByReleaseDateDescTitleAsc(Author author);

    List<Book> findAllTitlesByAgeRestriction(String agerRestriction);

    List<Book> findGoldenBooksWithLessThan5kCopies();

    List<Book> findBooksByPriceLowerOrUpperThan();

    List<Book> findBooksReleasedNotInGiverYear(int year);

    List<Book> findBooksReleasedBeforeDate(String date);

    List<Book> findBooksThanContainGivenString(String input);

    List<Book> findBooksByAuthorLastNameStartsWith(String letters);

    int countBooksWithTitleLongerThanGiven(int length);

    List<Object[]> findTotalBooksCopiesByAuthor();

    String[] findBookInfoByTitle(String title);

    int updateCopiesOfBooksReleasedBeforeDate(String date, int copies);

    int getAuthorWrittenBookCountUsingUSP(String fullName);

    int deleteBookByCopiesLowerThanGiven(int copies);
}
