package mk.finki.ukim.emtlabs.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NoBookAvailableException extends RuntimeException{

    public NoBookAvailableException(Long id) {
        super(String.format("Book with id: %d has no more copies", id));
    }
}