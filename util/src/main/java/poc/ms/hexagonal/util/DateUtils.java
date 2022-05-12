package poc.ms.hexagonal.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Slf4j
@UtilityClass
public class DateUtils {

    public static String formatDateIn(final String date, final DateFormat dateFormat) {
        try {
            final LocalDate localDate = LocalDate.parse(date);
            return localDate.format(DateTimeFormatter.ofPattern(dateFormat.getFormat()));
        } catch (DateTimeParseException e) {
            log.error("Error parsing date {} in format {}, details: ", date, dateFormat, e);
            return null;
        }
    }

    public static LocalDate toLocalDate(final String date, final DateFormat dateFormat) {
        try {
            DateTimeFormatter parser = DateTimeFormatter.ofPattern(dateFormat.getFormat());
            return LocalDate.parse(date, parser);
        } catch (DateTimeParseException e) {
            log.error("Fail to parse date ", e);
        }
        return null;
    }

    public boolean isValid(final String date, final DateFormat dateFormat) {
        try {
            final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat.getFormat());
            LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            log.error("Error parsing date. Invalid format of date {}. Details: ", date, e);
            return false;
        }
        return true;
    }

    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public enum DateFormat {
        MM_YYYY("MM/yyyy"),
        YYYY_MM_DD("yyyy-MM-dd"),
        DD_MM_YYYY("dd/MM/yyyy");
        private final String format;
    }
}
