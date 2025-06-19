package dev.stepherson.customer.exception;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdNotFoundExcepiton extends RuntimeException {

    public IdNotFoundExcepiton(UUID id) {
        super("Client with id " + id + " not found.");
    }

}
