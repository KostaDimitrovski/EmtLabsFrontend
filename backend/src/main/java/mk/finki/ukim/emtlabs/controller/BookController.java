package mk.finki.ukim.emtlabs.controller;

import mk.finki.ukim.emtlabs.model.Book;
import mk.finki.ukim.emtlabs.model.dto.BookDto;
import mk.finki.ukim.emtlabs.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public List<Book> findAll() {
        return this.bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable Long id) {
//        return this.bookService.findBookById(id)
//                .map(book -> ResponseEntity.ok().body(book))
//                .orElseGet(() -> ResponseEntity.notFound().build());
        Book book = this.bookService.findBookById(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(book);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody BookDto bookDto) {
        Book book = this.bookService.addBook(bookDto);
        if (book == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(book);
        }
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody BookDto bookDto)
    {
        Book book=this.bookService.editBook(id,bookDto);
        if (book == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(book);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id)
    {
        Book book=this.bookService.findBookById(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        } else {
            bookService.deleteBook(id);
            return ResponseEntity.ok(book);
        }
    }
    @PostMapping("/mark/{id}")
    public ResponseEntity<Book> markBook(@PathVariable Long id)
    {
        Book book=this.bookService.findBookById(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        } else {
            if(book.getAvailableCopies()<=0){
                return new ResponseEntity("No more books available.", HttpStatus.NOT_FOUND);
            }
            else
            {
                bookService.markBookAsTaken(id);
                return ResponseEntity.ok(book);
            }

        }
    }

}
