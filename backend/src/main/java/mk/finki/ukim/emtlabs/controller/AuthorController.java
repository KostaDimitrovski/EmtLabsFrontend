package mk.finki.ukim.emtlabs.controller;

import mk.finki.ukim.emtlabs.model.Author;
import mk.finki.ukim.emtlabs.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/list")
    public List<Author> findAll() {
        return this.authorService.findAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findAuthorById(@PathVariable Long id) {
        Author author = this.authorService.findAuthorById(id);
        if (author == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(author);
        }
    }

}
