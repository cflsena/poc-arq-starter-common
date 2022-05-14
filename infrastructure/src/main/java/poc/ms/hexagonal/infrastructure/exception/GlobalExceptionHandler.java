package poc.ms.hexagonal.infrastructure.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import poc.ms.hexagonal.component.MessageSourceReader;
import poc.ms.hexagonal.error.Error;
import poc.ms.hexagonal.exception.*;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final MessageSourceReader messageSourceReader;

    @ExceptionHandler({DomainException.class, BusinessException.class})
    public ResponseEntity<Error> handle(final BaseException ex) {
        return new ResponseEntity<>(transform(ex.getError()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<Error> handle(final ForbiddenException ex) {
        return new ResponseEntity<>(transform(ex.getError()), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Error> handle(final UnauthorizedException ex) {
        return new ResponseEntity<>(transform(ex.getError()), HttpStatus.UNAUTHORIZED);
    }

    private Error transform(final Error error) {
        var errorsTransformed = new Error();
        error.getErrors().forEach(emd -> errorsTransformed.add(emd.getCode(),
                messageSourceReader.getMessageById(emd.getMessage())));
        return errorsTransformed;
    }

}
