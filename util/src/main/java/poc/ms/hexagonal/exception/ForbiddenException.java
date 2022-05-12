package poc.ms.hexagonal.exception;

import poc.ms.hexagonal.error.Error;
import poc.ms.hexagonal.message.MessageTemplate;

import java.io.Serial;

public class ForbiddenException extends BaseException {

    @Serial
    private static final long serialVersionUID = -7388862126254807602L;

    protected ForbiddenException(final MessageTemplate messageTemplate) {
        super(messageTemplate);
    }

    protected ForbiddenException(final Error error) {
        super(error);
    }
}
