package ua.park.gorky.core.exception;

/**
 * @author Vladyslav
 */
public class TranscationException extends RuntimeException {
    public TranscationException() {
    }

    public TranscationException(String message) {
        super(message);
    }

    public TranscationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TranscationException(Throwable cause) {
        super(cause);
    }
}
