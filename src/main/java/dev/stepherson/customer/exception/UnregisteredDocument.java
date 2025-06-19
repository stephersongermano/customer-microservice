package dev.stepherson.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnregisteredDocument extends RuntimeException {

    public UnregisteredDocument(String document) {
        super("Client with document " + document + " not found.");
    }

}
