package com.example.sd11_exercisespringdataadvancedquerying.services.seed;

import com.example.sd11_exercisespringdataadvancedquerying.models.Author;
import com.example.sd11_exercisespringdataadvancedquerying.models.Book;
import com.example.sd11_exercisespringdataadvancedquerying.models.Category;
import com.example.sd11_exercisespringdataadvancedquerying.models.enums.AgeRestrictionType;
import com.example.sd11_exercisespringdataadvancedquerying.models.enums.BookEditionType;
import com.example.sd11_exercisespringdataadvancedquerying.services.author.AuthorService;
import com.example.sd11_exercisespringdataadvancedquerying.services.book.BookService;
import com.example.sd11_exercisespringdataadvancedquerying.services.category.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.sd11_exercisespringdataadvancedquerying.constants.FilePath.*;


@Service
public class SeedServiceImpl implements SeedService {

    private final AuthorService authorService;
    private final BookService bookService;
    private final CategoryService categoryService;

    public SeedServiceImpl(AuthorService authorService, BookService bookService, CategoryService categoryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    /**
     * Note: Due to my project is arranged with modules instead of different project for each Lab/Exercise
     * I've put a SPECIFIC_PATH variable to specify SD09_Exercise-SpringDataIntro module,
     * so for your project you may need to remove that variable from the Path.of() method.
     */
    @Override
    public void seedAuthors() throws IOException {

        if (!this.authorService.isDataSeeded()) {

            this.authorService
                    .seedAuthors(Files.readAllLines(Path.of(SPECIFIC_PATH + RESOURCE_PATH + AUTHOR_FILE_NAME))
                            .stream()
                            .filter(e -> !e.isBlank())
                            .map(e -> Author.builder()
                                    .firstName(e.split("\\s+")[0])
                                    .lastName(e.split("\\s+")[1])
                                    .build())
                            .collect(Collectors.toList()));
        }
    }

    @Override
    public void seedCategories() throws IOException {

        if (!this.categoryService.isDataSeeded()) {

            this.categoryService
                    .seedCategories(Files.readAllLines(Path.of(SPECIFIC_PATH + RESOURCE_PATH + CATEGORY_FILE_NAME))
                            .stream()
                            .filter(e -> !e.isBlank())
                            .map(e -> Category.builder()
                                    .name(e)
                                    .build())
                            .collect(Collectors.toList()));
        }
    }

    @Override
    public void seedBooks() throws IOException {

        if (!this.bookService.isDataSeeded()) {

            final List<Book> books = Files.readAllLines(Path.of(SPECIFIC_PATH + RESOURCE_PATH + BOOK_FILE_NAME))
                    .stream()
                    .filter(e -> !e.isBlank())
                    .map(row -> {

                        String[] data = row.split("\\s+");

                        String title = Arrays.stream(data).skip(5).collect(Collectors.joining(" "));

                        return Book.builder()
                                .title(title)
                                .bookEditionType(BookEditionType.values()[Integer.parseInt(data[0])])
                                .price(new BigDecimal(data[3]))
                                .releaseDate(LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/M/yyyy")))
                                .ageRestriction(AgeRestrictionType.values()[Integer.parseInt(data[4])])
                                .author(authorService.getRandomAuthor())
                                .categories(this.categoryService.getRandomCategories())
                                .copies(Integer.parseInt(data[2]))
                                .build();
                    })
                    .collect(Collectors.toList());

            this.bookService.seedBooks(books);

        }
    }
}

