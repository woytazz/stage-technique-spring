package pl.technique.stage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AccountNotFoundException extends ResponseStatusException {
    private static final HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;

    public AccountNotFoundException() {
        super(HTTP_STATUS);
    }
}
