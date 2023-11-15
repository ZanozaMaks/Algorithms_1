package Algorithms;

public class elementNotFoundException extends RuntimeException {
    public elementNotFoundException() {
    }

    public elementNotFoundException(String message) {
        super(message);
    }

    public elementNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public elementNotFoundException(Throwable cause) {
        super(cause);
    }

    public elementNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
