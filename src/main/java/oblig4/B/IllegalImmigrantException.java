package oblig4.B;

public class IllegalImmigrantException extends Exception {
    public IllegalImmigrantException() {
    }

    public IllegalImmigrantException(String message) {
        super(message);
    }

    public IllegalImmigrantException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalImmigrantException(Throwable cause) {
        super(cause);
    }

    public IllegalImmigrantException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
