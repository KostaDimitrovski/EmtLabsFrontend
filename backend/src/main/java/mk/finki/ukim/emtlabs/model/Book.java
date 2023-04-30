package mk.finki.ukim.emtlabs.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.finki.ukim.emtlabs.model.enums.Category;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne
    private Author author;
    private int availableCopies;

    public Book() {
    }
}
