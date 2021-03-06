package ua.park.gorky.core.entity.exception;

/**
 * @user Vladyslav
 */
public class ApplicationInitializationException extends RuntimeException {
    public ApplicationInitializationException() {
    }

    public ApplicationInitializationException(String message) {
        super(message);
    }

    public ApplicationInitializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationInitializationException(Throwable cause) {
        super(cause);
    }
}
