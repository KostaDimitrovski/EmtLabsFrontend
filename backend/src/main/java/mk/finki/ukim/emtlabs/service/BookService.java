package mk.finki.ukim.emtlabs.service;

import mk.finki.ukim.emtlabs.model.Book;
import mk.finki.ukim.emtlabs.model.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();
    Book findBookById(Long id);
    Book addBook(BookDto book);
    Book editBook(Long id, BookDto book);
    void deleteBook(Long id);
    void markBookAsTaken(Long id);
}
