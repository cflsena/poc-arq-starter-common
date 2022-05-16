package poc.ms.hexagonal.assertion;

import lombok.experimental.UtilityClass;
import poc.ms.hexagonal.exception.BaseException;

import java.util.Collection;
import java.util.Map;

@UtilityClass
public class Assert {

    public static void isTrue(final boolean condition, final BaseException ex) {
        if (!condition) throwException(ex);
    }

    public static void isFalse(final boolean condition, final BaseException ex) {
        if (condition) throwException(ex);
    }

    public static void isNull(final Object value, final BaseException ex) {
        if (value != null) throwException(ex);
    }

    public static void isNotNull(final Object value, final BaseException ex) {
        if (value == null) {
            throwException(ex);
        }
    }

    public static void isNotEmpty(final String value, final BaseException ex) {
        if (value == null || value.trim().length() == 0) throwException(ex);
    }

    public static void isNotEmpty(final Collection<?> value, final BaseException ex) {
        isNotNull(value, ex);
        if (value.isEmpty())
            throwException(ex);
    }

    public static void isNotEmpty(final Map<?, ?> value, final BaseException ex) {
        isNotNull(value, ex);
        if (value.isEmpty()) throwException(ex);
    }

    public static <T> void isNotEmpty(final T[] value, final BaseException ex) {
        isNotNull(value, ex);
        if (value.length == 0) throwException(ex);
    }

    private static <T extends BaseException> void throwException(final T ex) throws T {
        throw ex;
    }

}
