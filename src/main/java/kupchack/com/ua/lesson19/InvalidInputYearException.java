package kupchack.com.ua.lesson19;

/**
 * Created by Home on 15.09.2017.
 */
public class InvalidInputYearException extends Exception {
    public InvalidInputYearException() {
        super();
    }

    public InvalidInputYearException(String message) {
        super(message);
    }

    public InvalidInputYearException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInputYearException(Throwable cause) {
        super(cause);
    }

    protected InvalidInputYearException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
