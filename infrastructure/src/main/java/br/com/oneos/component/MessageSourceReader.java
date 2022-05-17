package br.com.oneos.component;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class MessageSourceReader {
    private final MessageSource messageSource;

    public String getMessageById(final String messageId) {

        return messageSource.getMessage(
                messageId,
                null,
                Locale.getDefault()
        );
    }
}
