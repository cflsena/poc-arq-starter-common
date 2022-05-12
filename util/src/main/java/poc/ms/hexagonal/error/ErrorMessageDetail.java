package poc.ms.hexagonal.error;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorMessageDetail {

    private final LocalDateTime dateTime;
    private final String code;
    private final String message;

    public ErrorMessageDetail(final String code, final String message) {
        this.dateTime = LocalDateTime.now();
        this.message = message;
        this.code = code;
    }

}
