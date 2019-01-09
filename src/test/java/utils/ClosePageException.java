package utils;

public class ClosePageException extends Exception {

    public ClosePageException() {
    }

    public ClosePageException(String message) {
        super(message);
    }

    public ClosePageException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClosePageException(Throwable cause) {
        super(cause);
    }

    public ClosePageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
