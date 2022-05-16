package poc.ms.hexagonal.message;

public interface MessageSourceCustom {
    String findMessageBy(String messageId);
}
