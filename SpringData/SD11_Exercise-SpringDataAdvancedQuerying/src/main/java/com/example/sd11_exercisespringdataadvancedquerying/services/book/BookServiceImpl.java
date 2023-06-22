package com.example.sd11_exercisespringdataadvancedquerying.services.book;

import com.example.sd11_exercisespringdataadvancedquerying.models.Author;
import com.example.sd11_exercisespringdataadvancedquerying.models.Book;
import com.example.sd11_exercisespringdataadvancedquerying.models.enums.AgeRestrictionType;
import com.example.sd11_exercisespringdataadvancedquerying.models.enums.BookEditionType;
import com.example.sd11_exercisespringdataadvancedquerying.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.Locale;
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

    @Override
    public List<Book> findAllTitlesByAgeRestriction(String ageRestriction) {

        final AgeRestrictionType ageRestrictionType = AgeRestrictionType.valueOf(ageRestriction.toUpperCase());

        return this.bookRepository.findBooksByAgeRestriction(ageRestrictionType)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> findGoldenBooksWithLessThan5kCopies() {

        final int copies = 5000;
        final BookEditionType editionType = BookEditionType.GOLD;

        return this.bookRepository.findBooksByBookEditionTypeAndCopiesLessThan(editionType, copies)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> findBooksByPriceLowerOrUpperThan() {

        final BigDecimal lowerPrice = BigDecimal.valueOf(5);
        final BigDecimal higherPrice = BigDecimal.valueOf(40);

        return this.bookRepository.findBooksByPriceLessThanOrPriceGreaterThan(lowerPrice, higherPrice)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> findBooksReleasedNotInGiverYear(int year) {

        return this.bookRepository.findBooksByReleaseDateIsNot(year);
    }

    @Override
    public List<Book> findBooksReleasedBeforeDate(String date) {

        int day = Integer.parseInt(date.split("-")[0]);
        int month = Integer.parseInt(date.split("-")[1]);
        int year = Integer.parseInt(date.split("-")[2]);

        LocalDate dateFormatted = LocalDate.of(year, month, day);

        return this.bookRepository.findBooksByReleaseDateBefore(dateFormatted)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> findBooksThanContainGivenString(String input) {

        return this.bookRepository.findBooksByTitleContainsIgnoreCase(input)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> findBooksByAuthorLastNameStartsWith(String letters) {

        return this.bookRepository.findBooksByAuthorLastNameStartsWithIgnoreCase(letters)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public int countBooksWithTitleLongerThanGiven(int length) {

        return this.bookRepository.countBooksByTitleLengthGreaterThan(length);
    }

    @Override
    public List<Object[]> findTotalBooksCopiesByAuthor() {

        return this.bookRepository.findTotalBooksCopiesByAuthor()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public String[] findBookInfoByTitle(String title) {

        return this.bookRepository.findBookInfoByTitle(title)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    @Transactional
    public int updateCopiesOfBooksReleasedBeforeDate(String date, int copies) {

        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("dd-MMM-yyyy")
                .toFormatter(Locale.ENGLISH);

        date = date.trim().replaceAll(" ", "-");

        LocalDate dateFormatted = LocalDate.parse(date, formatter);

        System.out.println();

        return this.bookRepository.updateCopiesOfBooksReleasedBeforeDate(dateFormatted, copies)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public int getAuthorWrittenBookCountUsingUSP(String fullName) {

        return this.bookRepository.getAuthorWrittenBookCountUsingUSP(fullName);
    }

    @Override
    @Transactional
    public int deleteBookByCopiesLowerThanGiven(int copies) {
        return this.bookRepository.deleteBookByCopiesLessThan(copies);
    }
}
