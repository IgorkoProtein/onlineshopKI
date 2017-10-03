package kupchack.com.ua.onlineShop.users;

/**
 * Created by Home on 18.09.2017.
 */
public class InputExceptoin extends Exception {
    public InputExceptoin() {
        super();
    }

    public InputExceptoin(String message) {
        super(message);
    }

    public InputExceptoin(String message, Throwable cause) {
        super(message, cause);
    }

    public InputExceptoin(Throwable cause) {
        super(cause);
    }

    protected InputExceptoin(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
