package br.com.oneos.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

@Slf4j
@UtilityClass
public class FormatterUtil {

    public static String formatField(final String value, final String pattern) throws ParseException {
        var formatter = new MaskFormatter(pattern);
        formatter.setValueContainsLiteralCharacters(false);
        return formatter.valueToString(value);
    }

}
