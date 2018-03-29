package kupchack.com.ua.lesson40;

public class Factory {
    public static void startService (ServiceFactory factory) {
        Service someservise = factory.createService();
        someservise.provideService();
    }
}
