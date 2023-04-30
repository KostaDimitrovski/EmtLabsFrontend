package mk.finki.ukim.emtlabs.service;

import mk.finki.ukim.emtlabs.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuthorService {
    List<Author> findAllAuthors();
    Author findAuthorById(Long id);
}
