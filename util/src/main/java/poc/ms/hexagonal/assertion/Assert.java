package poc.ms.hexagonal.assertion;

import lombok.experimental.UtilityClass;
import poc.ms.hexagonal.exception.BaseException;
import poc.ms.hexagonal.message.MessageTemplate;

import java.util.Collection;
import java.util.Map;

@UtilityClass
public class Assert<T extends BaseException> {

    public static void isTrue(final boolean condition, final MessageTemplate messageTemplate) {
        if (!condition) {
            final var ex = getThrowInstance(messageTemplate);
            throwException(ex);
        }
    }

    public static void isFalse(boolean condition, MessageTemplate messageTemplate) {
        if (condition) {
            final var ex = getThrowInstance(messageTemplate);
            throwException(ex);
        }
    }

    public static void isNull(Object value, MessageTemplate messageTemplate) {
        if (value != null) {
            final var ex = getThrowInstance(messageTemplate);
            throwException(ex);
        }
    }

    public static void isNotNull(Object value, MessageTemplate messageTemplate) {
        if (value == null) {
            final var ex = getThrowInstance(messageTemplate);
            throwException(ex);
        }
    }

    public static void isNotEmpty(String value, MessageTemplate messageTemplate) {
        if (value == null || value.trim().length() == 0) {
            final var ex = getThrowInstance(messageTemplate);
            throwException(ex);
        }
    }

    public static void isNotEmpty(Collection<?> value, MessageTemplate messageTemplate) {
        isNotNull(value, messageTemplate);
        if (value.isEmpty()) {
            final var ex = getThrowInstance(messageTemplate);
            throwException(ex);
        }
    }

    public static void isNotEmpty(Map<?, ?> value, MessageTemplate messageTemplate) {
        isNotNull(value, messageTemplate);
        if (value.isEmpty()) {
            final var ex = getThrowInstance(messageTemplate);
            throwException(ex);
        }
    }

    public static <T> void isNotEmpty(T[] value, MessageTemplate messageTemplate) {
        isNotNull(value, messageTemplate);
        if (value.length == 0) {
            final var ex = getThrowInstance(messageTemplate);
            throwException(ex);
        }
    }

    @SuppressWarnings("unchecked")
    private static <T extends BaseException> T getThrowInstance(final MessageTemplate messageTemplate) {
        return (T) new BaseException(messageTemplate);
    }

    private static <T extends BaseException> void throwException(final T ex) throws T {
        throw ex;
    }

}
