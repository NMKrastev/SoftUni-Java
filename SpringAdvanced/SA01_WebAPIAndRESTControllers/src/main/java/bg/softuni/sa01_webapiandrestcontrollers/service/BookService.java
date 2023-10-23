package bg.softuni.sa01_webapiandrestcontrollers.service;

import bg.softuni.sa01_webapiandrestcontrollers.model.dto.AuthorDTO;
import bg.softuni.sa01_webapiandrestcontrollers.model.dto.BookDTO;
import bg.softuni.sa01_webapiandrestcontrollers.model.entity.Author;
import bg.softuni.sa01_webapiandrestcontrollers.model.entity.Book;
import bg.softuni.sa01_webapiandrestcontrollers.repository.AuthorRepository;
import bg.softuni.sa01_webapiandrestcontrollers.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Optional<BookDTO> getBookBtId(Long bookId) {

        return this.bookRepository
                .findById(bookId)
                .map(this::map);
    }

    public List<BookDTO> getAllBooks() {

        return this.bookRepository
                .findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    public void deleteBookById(Long id) {

        this.bookRepository
                .deleteById(id);
    }

    public Long createBook(BookDTO bookDTO) {

        Author author = this.authorRepository
                .findByName(bookDTO.getAuthor().getName())
                .orElse(null);

        if (author == null) {
            author = new Author()
                    .builder()
                    .name(bookDTO.getAuthor().getName())
                    .build();
            author = this.authorRepository.save(author);
        }

        Book book = new Book()
                .builder()
                .author(author)
                .isbn(bookDTO.getIsbn())
                .title(bookDTO.getTitle())
                .build();

        Book newBook = this.bookRepository.save(book);

        return newBook.getId();
    }

    private BookDTO map(Book book) {

        return BookDTO
                .builder()
                .id(book.getId())
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .author(new AuthorDTO().builder().name(book.getAuthor().getName()).build())
                .build();
    }
}
