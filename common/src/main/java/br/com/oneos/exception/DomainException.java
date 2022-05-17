package br.com.oneos.exception;

import br.com.oneos.error.Error;
import br.com.oneos.message.MessageTemplate;

import java.io.Serial;

public class DomainException extends BaseException {

    @Serial
    private static final long serialVersionUID = -4213790888297175635L;

    public DomainException(final MessageTemplate messageTemplate) {super(messageTemplate);}
    public DomainException(final Error error) {
        super(error);
    }
}
