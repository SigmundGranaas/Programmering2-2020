package oblig4.A;

public class ZooException extends Exception {
    public ZooException(String message) {
        super(message);
    }

    public ZooException(String message, Throwable cause) {
        super(message, cause);
    }

    public ZooException(Throwable cause) {
        super(cause);
    }

    public ZooException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
