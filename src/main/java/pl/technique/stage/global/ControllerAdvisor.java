package pl.technique.stage.global;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.technique.stage.entity.Account;
import pl.technique.stage.entity.Company;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException exception, WebRequest request) {
        HttpStatus httpStatus = HttpStatus.CONFLICT;

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", httpStatus.value());
        body.put("error", httpStatus.getReasonPhrase());
        if (Objects.requireNonNull(exception.getMessage()).contains(Account.CONSTRAINT_LOGIN_UNIQUE)) {
            body.put("message", Account.CONSTRAINT_LOGIN_UNIQUE);
        } else if (exception.getMessage().contains(Account.CONSTRAINT_EMAIL_UNIQUE)) {
            body.put("message", Account.CONSTRAINT_EMAIL_UNIQUE);
        } else if (exception.getMessage().contains(Company.CONSTRAINT_COMPANY_NAME_UNIQUE)) {
            body.put("message", Company.CONSTRAINT_COMPANY_NAME_UNIQUE);
        } else if (exception.getMessage().contains(Company.CONSTRAINT_NIP_UNIQUE)) {
            body.put("message", Company.CONSTRAINT_NIP_UNIQUE);
        } else if (exception.getMessage().contains(Company.CONSTRAINT_ADDRESS_UNIQUE)) {
            body.put("message", Company.CONSTRAINT_ADDRESS_UNIQUE);
        } else {
            body.put("message", "Data Integrity Violation Exception");
        }
        return new ResponseEntity<>(body, httpStatus);
    }

    @ExceptionHandler(value = ObjectOptimisticLockingFailureException.class)
    public ResponseEntity<Object> handleObjectOptimisticLockingFailureException(ObjectOptimisticLockingFailureException exception, WebRequest request) {
        HttpStatus httpStatus = HttpStatus.CONFLICT;

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", httpStatus.value());
        body.put("error", httpStatus.getReasonPhrase());
        body.put("message", "Optimistic Lock Exception");

        return new ResponseEntity<>(body, httpStatus);
    }
}
