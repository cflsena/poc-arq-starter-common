package br.com.oneos.exception;

import lombok.Getter;
import br.com.oneos.error.Error;
import br.com.oneos.message.MessageTemplate;

import java.io.Serial;

@Getter
public class BaseException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 5017800280141188329L;
    private final Error error;

    public BaseException(final MessageTemplate messageTemplate) {
        super(messageTemplate.message(), null, true, false);
        this.error = new Error();
        this.error.add(messageTemplate.code(), messageTemplate.message());
    }

    public BaseException(final Error error) {
        super(error.allMessagesConcatenated(), null, true, false);
        this.error = error;
    }

}
