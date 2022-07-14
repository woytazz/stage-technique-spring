package pl.technique.stage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UpdateException extends ResponseStatusException {
    private static final HttpStatus HTTP_STATUS = HttpStatus.CONFLICT;

    public UpdateException() {
        super(HTTP_STATUS);
    }
}
