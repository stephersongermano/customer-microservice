package dev.stepherson.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DocumentAlreadyExistsException extends RuntimeException {

    public DocumentAlreadyExistsException(String document) {
        super("Client with document " + document + " already exists.");
    }

}
