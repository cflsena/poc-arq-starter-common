package br.com.oneos.exception;

import br.com.oneos.error.Error;
import br.com.oneos.message.MessageTemplate;

import java.io.Serial;

public class UnauthorizedException extends BaseException {

    @Serial
    private static final long serialVersionUID = -6657417924650432534L;

    public UnauthorizedException(final MessageTemplate messageTemplate) {
        super(messageTemplate);
    }
    public UnauthorizedException(final Error error) {
        super(error);
    }
}
