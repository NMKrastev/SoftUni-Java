package com.example.A1_BookshopSystem;

import com.example.A1_BookshopSystem.models.Author;
import com.example.A1_BookshopSystem.models.Book;
import com.example.A1_BookshopSystem.services.author.AuthorService;
import com.example.A1_BookshopSystem.services.book.BookService;
import com.example.A1_BookshopSystem.services.seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.example.A1_BookshopSystem.constants.Constant.*;

@Component //- Very similar to Service - can be used if something is not quite a Service
//@Service
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public ConsoleRunner(SeedService seedService, AuthorService authorService, BookService bookService) {
        this.seedService = seedService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {

        //Populates the DB with the given files
        this.seedService.seedAllData();

        //1. Get all books after the year 2000. Print only their titles.
        this.getAllBooksAfterGivenYear();

        //2. Get all authors with at least one book with a release date before 1990. Print their first name and last name.
        this.getAllAuthorsWithBookBeforeGivenYear();

        //3. Get all authors, ordered by the number of their books (descending). Print their first name, last name and book count.
        this.getAllAuthorsByNumberOfBooks();

        //4. Get all books from author George Powell, ordered by their release date (descending),
        //then by book title (ascending). Print the book's title, release date and copies.
        this.getAllBooksByAuthor();

    }

    private void getAllBooksByAuthor() {

        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("4. Get all books from author George Powell, ordered by their release date (descending), \n" +
                "then by book title (ascending). Print the book's title, release date and copies.");

        String firstName = FULL_NAME.split("\\s+")[0];
        String lastName = FULL_NAME.split("\\s+")[1];
        Author author = authorService.findAuthorByFirstNameAndLastName(firstName, lastName);

        List<Book> books = bookService.findAllByAuthorOrderByReleaseDateDescTitleAsc(author);

        books.forEach(e -> System.out.printf("Title: %s, Release date: %s, Copies: %d\n", e.getTitle(), e.getReleaseDate(), e.getCopies()));
    }

    private void getAllAuthorsByNumberOfBooks() {

        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("3. Get all authors, ordered by the number of their books (descending). Print their first name, last name and book count.");

        List<Object[]> allAuthorsByNumberOfTheirBooks = this.authorService.findAllAuthorsByNumberOfTheirBooks();

        Map<Author, Long> authorsByBooksCount = new LinkedHashMap<>();

        allAuthorsByNumberOfTheirBooks
                .forEach(e -> authorsByBooksCount.put((Author) e[0], (Long) e[1]));

        authorsByBooksCount
                .forEach((author, count) -> System.out.printf("%s %s - %d\n", author.getFirstName(), author.getLastName(), count));

    }

    private void getAllAuthorsWithBookBeforeGivenYear() {

        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("2. Get all authors with at least one book with a release date before 1990. Print their first name and last name.");

        List<Author> allByBooksReleaseDateBefore = this.authorService.findAllByBooksReleaseDateBefore(BOOK_BEFORE_YEAR);

        allByBooksReleaseDateBefore
                .forEach(e -> System.out.printf("%s %s\n", e.getFirstName(), e.getFirstName()));
    }

    private void getAllBooksAfterGivenYear() {

        System.out.println("1. Get all books after the year 2000. Print only their titles.");

        this.bookService.findBooksByReleaseDateAfter(BOOK_AFTER_YEAR)
                .forEach(e -> System.out.printf("Title: %s\n", e.getTitle()));
    }
}
