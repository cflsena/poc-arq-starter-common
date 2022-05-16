package poc.ms.hexagonal.exception;

import poc.ms.hexagonal.error.Error;
import poc.ms.hexagonal.message.MessageTemplate;

import java.io.Serial;

public class BusinessException extends BaseException {

    @Serial
    private static final long serialVersionUID = 2622025552606717491L;

    public BusinessException(final MessageTemplate messageTemplate) {
        super(messageTemplate);
    }

    public BusinessException(final Error error) {
        super(error);
    }
}
