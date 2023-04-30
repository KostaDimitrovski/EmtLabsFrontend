package mk.finki.ukim.emtlabs.service.impl;

import mk.finki.ukim.emtlabs.model.Book;
import mk.finki.ukim.emtlabs.model.dto.BookDto;
import mk.finki.ukim.emtlabs.model.exceptions.AuthorNotFoundException;
import mk.finki.ukim.emtlabs.model.exceptions.BookNotFoundException;
import mk.finki.ukim.emtlabs.model.exceptions.NoBookAvailableException;
import mk.finki.ukim.emtlabs.repository.AuthorRepository;
import mk.finki.ukim.emtlabs.repository.BookRepository;
import mk.finki.ukim.emtlabs.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;

        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book addBook(BookDto book) {
        Book book1=new Book();
        book1.setAuthor(authorRepository.findById(book.getAuthorId()).orElseThrow(()->new AuthorNotFoundException(book.getAuthorId())));
        book1.setCategory(book.getCategory());
        book1.setName(book.getName());
        book1.setAvailableCopies(book.getAvailableCopies());

        return bookRepository.save(book1);
    }

    @Override
    public Book editBook(Long id, BookDto book) {

        Book book1=bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id));
        book1.setAuthor(authorRepository.findById(book.getAuthorId()).orElseThrow(()->new AuthorNotFoundException(book.getAuthorId())));
        book1.setCategory(book.getCategory());
        book1.setName(book.getName());
        book1.setAvailableCopies(book.getAvailableCopies());

        return bookRepository.save(book1);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);

    }

    @Override
    public void markBookAsTaken(Long id) {
        Book book1=bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id));
        if(book1.getAvailableCopies()>0) {
            book1.setAvailableCopies(book1.getAvailableCopies() - 1);
        }
        else {
            throw new NoBookAvailableException(id);
        }
        bookRepository.save(book1);
    }
}
