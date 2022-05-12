package poc.ms.hexagonal.exception;

import lombok.Getter;
import poc.ms.hexagonal.error.Error;
import poc.ms.hexagonal.message.MessageTemplate;

import java.io.Serial;

@Getter
public abstract class BaseException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 5017800280141188329L;
    private final Error error;

    protected BaseException(final MessageTemplate messageTemplate) {
        super(messageTemplate.message(), null, true, false);
        this.error = new Error();
        this.error.add(messageTemplate.code(), messageTemplate.message());
    }

    protected BaseException(final Error error) {
        super(error.allMessagesConcatenated(), null, true, false);
        this.error = error;
    }

}
