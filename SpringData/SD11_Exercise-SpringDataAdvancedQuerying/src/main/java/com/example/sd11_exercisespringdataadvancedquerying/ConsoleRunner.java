package com.example.sd11_exercisespringdataadvancedquerying;

import com.example.sd11_exercisespringdataadvancedquerying.models.Author;
import com.example.sd11_exercisespringdataadvancedquerying.models.Book;
import com.example.sd11_exercisespringdataadvancedquerying.services.author.AuthorService;
import com.example.sd11_exercisespringdataadvancedquerying.services.book.BookService;
import com.example.sd11_exercisespringdataadvancedquerying.services.seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.example.sd11_exercisespringdataadvancedquerying.constants.Constant.*;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private static final Scanner scanner = new Scanner(System.in);

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
        //this.seedService.seedAllData();

        System.out.print(ENTER_TASK_NUMBER);
        int taskNumber = Integer.parseInt(scanner.nextLine());

        switch (taskNumber) {
            //1. Book Titles By Age Restriction
            case 1 -> getBooksTitleByAgeRestriction();
            //2. Golden Books
            case 2 -> getAllGoldenBooksWithLessThan5kCopies();
            //3. Books By Price
            case 3 -> getAllBooksByPriceLowerOrUpperThan();
            //4. Not Released Books
            case 4 -> getAllBooksNotReleaseInGivenYear();
            //5. Books Released Before Date
            case 5 -> getBooksReleasedBeforeDate();
            //6. Authors Search
            case 6 -> getAuthorsThatFirstNameEndsWith();
            //7. Books Search
            case 7 -> getBooksThatContainGivenString();
            //8. Book Titles Search
            case 8 -> getBooksByAuthorLastNameStartsWith();
            //9. Count Books
            case 9 -> getBooksCountWithTitleLongerThan();
            //10. Total Book Copies
            case 10 -> getBooksTotalCopiesByAuthor();
            //11. Reduced Book
            case 11 -> getTitLeEditionRestrictionPriceOfBook();
            //12. Increase Book Copies
            case 12 -> updateCopiesOfBooksReleasedBeforeDate();
            //13. Remove Books
            case 13 -> deleteBookByCopiesLowerThanGiven();
            //14. Stored Procedure
            case 14 -> getAuthorWrittenBookCountUsingUSP();

        }
    }

    /**
     * Use the following query to create the procedure using WorkBench or other client:<br><br>
     * DROP PROCEDURE IF EXISTS usp_get_count_of_written_books_by_author;
     * DELIMITER $$
     * CREATE PROCEDURE usp_get_count_of_written_books_by_author(full_name VARCHAR(50))
     * BEGIN
     * SELECT COUNT(b.author_id)
     * FROM books AS b
     * JOIN authors a ON a.id = b.author_id
     * WHERE CONCAT_WS(' ', a.first_name, a.last_name) = full_name;
     * END $$
     */
    private void getAuthorWrittenBookCountUsingUSP() {
        //14. Stored Procedure
        System.out.print(ENTER_AUTHOR_NAME);
        final String fullName = scanner.nextLine();

        final int count =
                this.bookService.getAuthorWrittenBookCountUsingUSP(fullName);

        System.out.printf(AUTHOR_NAME_BOOKS_COUNT_FORMAT, fullName, count);
    }

    private void deleteBookByCopiesLowerThanGiven() {
        //13. Remove Books
        System.out.print(ENTER_NUMBER_OF_COPIES);
        final int copies = Integer.parseInt(scanner.nextLine());

        int deletedBooksCount = this.bookService.deleteBookByCopiesLowerThanGiven(copies);

        System.out.println(deletedBooksCount);
    }

    private void updateCopiesOfBooksReleasedBeforeDate() {
        //12. Increase Book Copies
        System.out.print(ENTER_DATE_IN_FORMAT_2);
        final String date = scanner.nextLine();

        System.out.print(ENTER_NUMBER_OF_COPIES);
        final int copies = Integer.parseInt(scanner.nextLine());

        final int updatedBooks =
                this.bookService.updateCopiesOfBooksReleasedBeforeDate(date, copies);

        System.out.println(updatedBooks * copies);
    }

    private void getTitLeEditionRestrictionPriceOfBook() {
        //11. Reduced Book
        System.out.print(ENTER_BOOK_TITLE);
        final String title = scanner.nextLine();

        final String[] bookInfo = this.bookService.findBookInfoByTitle(title);

        System.out.printf("%s\n", bookInfo[0].replaceAll(",", " "));
    }

    private void getBooksTotalCopiesByAuthor() {
        //10. Total Book Copies

        final List<Object[]> totalBooksCopiesByAuthor =
                this.bookService.findTotalBooksCopiesByAuthor();

        final Map<Author, Long> authorTotalCopies = new LinkedHashMap<>();

        for (Object[] objects : totalBooksCopiesByAuthor) {
            authorTotalCopies.put((Author) objects[0], (Long) objects[1]);
        }

        authorTotalCopies
                .forEach((a, c) -> System.out.printf(AUTHOR_NAME_COUNT_FORMAT,
                        a.getFirstName(), a.getLastName(), c));

        System.out.println();
    }

    private void getBooksCountWithTitleLongerThan() {
        //9. Count Books
        System.out.print(ENTER_BOOK_TITLE_LENGTH);
        final int length = Integer.parseInt(scanner.nextLine());

        final int count =
                this.bookService.countBooksWithTitleLongerThanGiven(length);

        System.out.println(count);
    }

    private void getBooksByAuthorLastNameStartsWith() {
        //8. Book Titles Search
        System.out.print(ENTER_LETTERS);
        final String letters = scanner.nextLine();

        final List<Book> byAuthorLastNameStartsWith =
                this.bookService.findBooksByAuthorLastNameStartsWith(letters);

        byAuthorLastNameStartsWith
                .forEach(e -> System.out.printf(BOOK_TITLE_AUTHOR_NAME_FORMAT,
                        e.getTitle(), e.getAuthor().getFirstName(), e.getAuthor().getLastName()));
    }

    private void getBooksThatContainGivenString() {

        System.out.print(ENTER_STRING);
        final String input = scanner.nextLine();

        final List<Book> booksByGivenString =
                this.bookService.findBooksThanContainGivenString(input);

        booksByGivenString
                .forEach(e -> System.out.println(e.getTitle()));
    }

    private void getAuthorsThatFirstNameEndsWith() {
        //6. Authors Search
        System.out.print(ENTER_LETTERS);
        final String letters = scanner.nextLine();

        final List<Author> authorsThatFirstNameEndsWith =
                this.authorService.findAuthorsByFirstNameEndsWith(letters);

        authorsThatFirstNameEndsWith
                .forEach(e -> System.out.printf(AUTHOR_FIRST_LAST_NAME_FORMAT,
                        e.getFirstName(), e.getLastName()));
    }

    private void getBooksReleasedBeforeDate() {
        //5. Books Released Before Date
        System.out.print(ENTER_DATE_IN_FORMAT_1);
        final String date = scanner.nextLine();

        final List<Book> booksReleasedBefore =
                this.bookService.findBooksReleasedBeforeDate(date);

        booksReleasedBefore
                .forEach(e -> System.out.printf(BOOK_TITLE_EDITION_PRICE_FORMAT,
                        e.getTitle(), e.getBookEditionType(), e.getPrice()));
    }

    private void getAllBooksNotReleaseInGivenYear() {
        //4. Not Released Books
        System.out.print(ENTER_YEAR_OF_BOOK_RELEASE);
        final int year = Integer.parseInt(scanner.nextLine());

        final List<Book> booksReleasedNotInGivenYear =
                this.bookService.findBooksReleasedNotInGiverYear(year);

        booksReleasedNotInGivenYear
                .forEach(e -> System.out.println(e.getTitle()));
    }

    private void getAllBooksByPriceLowerOrUpperThan() {
        //3. Books By Price
        final List<Book> booksByPrice =
                this.bookService.findBooksByPriceLowerOrUpperThan();

        booksByPrice
                .forEach(e -> System.out.printf(BOOK_TITLE_PRICE_FORMAT, e.getTitle(), e.getPrice()));
    }

    private void getAllGoldenBooksWithLessThan5kCopies() {
        //2. Golden Books
        final List<Book> goldenBooks =
                this.bookService.findGoldenBooksWithLessThan5kCopies();

        goldenBooks
                .forEach(e -> System.out.println(e.getTitle()));
    }

    private void getBooksTitleByAgeRestriction() {
        //1. Book Titles By Age Restriction
        System.out.print(ENTER_AGE_RESTRICTION);
        String agerRestriction = scanner.nextLine();

        final List<Book> allTitlesByAgeRestriction =
                this.bookService.findAllTitlesByAgeRestriction(agerRestriction);

        allTitlesByAgeRestriction
                .forEach(e -> System.out.println(e.getTitle()));
    }
}
