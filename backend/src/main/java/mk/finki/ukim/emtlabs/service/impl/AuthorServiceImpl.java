package mk.finki.ukim.emtlabs.service.impl;

import mk.finki.ukim.emtlabs.model.Author;
import mk.finki.ukim.emtlabs.model.exceptions.AuthorNotFoundException;
import mk.finki.ukim.emtlabs.repository.AuthorRepository;
import mk.finki.ukim.emtlabs.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author findAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(()-> new AuthorNotFoundException(id));
    }
}
