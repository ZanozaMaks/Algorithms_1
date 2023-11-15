package Algorithms;

public class InvalidInexException extends RuntimeException {
    public InvalidInexException() {
    }

    public InvalidInexException(String message) {
        super(message);
    }

    public InvalidInexException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInexException(Throwable cause) {
        super(cause);
    }

    public InvalidInexException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
