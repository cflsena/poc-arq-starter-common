package poc.ms.hexagonal.exception;

import poc.ms.hexagonal.error.Error;
import poc.ms.hexagonal.message.MessageTemplate;
import java.io.Serial;

public class DomainException extends BaseException {

    @Serial
    private static final long serialVersionUID = -4213790888297175635L;

    protected DomainException(final MessageTemplate messageTemplate) {
        super(messageTemplate);
    }

    protected DomainException(final Error error) {
        super(error);
    }
}
