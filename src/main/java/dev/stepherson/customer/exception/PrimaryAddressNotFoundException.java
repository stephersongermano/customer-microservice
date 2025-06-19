package dev.stepherson.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PrimaryAddressNotFoundException extends RuntimeException {
    public PrimaryAddressNotFoundException() {
        super("Primary address not found");
    }
}
