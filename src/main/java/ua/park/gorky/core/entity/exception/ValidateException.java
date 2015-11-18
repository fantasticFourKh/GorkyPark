package ua.park.gorky.core.entity.exception;

/**
 * Created by Владислав on 17 ноя 2015 г..
 */
public class ValidateException extends RuntimeException {

    public ValidateException() {
        super();
    }

    public ValidateException(String message) {
        super(message);
    }

    public ValidateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateException(Throwable cause) {
        super(cause);
    }

    protected ValidateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
