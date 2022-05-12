package poc.ms.hexagonal.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FormatterUtils {

    public static final String CNPJ_FORMAT = "##.###.###/####-##";
    public static final String CPF_FORMAT = "###.###.###-##";

    public static String formatDocumentNumber(@NonNull final String documentNumber) {
        try {
            if (documentNumber.length() > 11) {
                return formatField(CNPJ_FORMAT, documentNumber);
            }
            return formatField(CPF_FORMAT, documentNumber);
        } catch (ParseException e) {
            log.warn("Error to format document number with value {}. The document number will be sent unformatted. Details: ", documentNumber, e);
        }
        return documentNumber;
    }

    private static String formatField(final String pattern, final String value) throws ParseException {
        var formatter = new MaskFormatter(pattern);
        formatter.setValueContainsLiteralCharacters(false);
        return formatter.valueToString(value);
    }

}
