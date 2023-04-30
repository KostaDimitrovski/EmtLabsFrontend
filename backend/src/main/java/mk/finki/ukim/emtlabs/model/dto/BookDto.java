package mk.finki.ukim.emtlabs.model.dto;

import lombok.Data;
import mk.finki.ukim.emtlabs.model.enums.Category;

@Data
public class BookDto {
    private String name;
    private Category category;
    private Long authorId;
    private Integer availableCopies;
}
