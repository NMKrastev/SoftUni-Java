package bg.softuni.sa01_webapiandrestcontrollers.web;

import bg.softuni.sa01_webapiandrestcontrollers.model.dto.BookDTO;
import bg.softuni.sa01_webapiandrestcontrollers.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/books")
public class BooksController {

    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return ResponseEntity
                .ok(this.bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable("id") Long bookId) {

        Optional<BookDTO> bookOpt = this.bookService.getBookBtId(bookId);

        return bookOpt
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookDTO> deleteBookById(@PathVariable("id") Long bookId) {

        this.bookService.deleteBookById(bookId);

        return ResponseEntity
                .noContent()
                .build();
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO, UriComponentsBuilder uriComponentsBuilder) {

        Long bookId = this.bookService.createBook(bookDTO);

        return ResponseEntity
                .created(uriComponentsBuilder
                        .path("/api/books/{id}")
                        .build(bookId))
                .build();
    }

}
