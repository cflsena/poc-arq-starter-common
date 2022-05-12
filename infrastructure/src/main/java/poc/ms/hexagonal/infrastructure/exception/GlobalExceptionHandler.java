package poc.ms.hexagonal.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import poc.ms.hexagonal.error.Error;
import poc.ms.hexagonal.exception.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({DomainException.class, BusinessException.class})
    public ResponseEntity<Error> handle(final BaseException ex) {
        return new ResponseEntity<>(ex.getError(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<Error> handle(final ForbiddenException ex) {
        return new ResponseEntity<>(ex.getError(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Error> handle(final UnauthorizedException ex) {
        return new ResponseEntity<>(ex.getError(), HttpStatus.UNAUTHORIZED);
    }

}
