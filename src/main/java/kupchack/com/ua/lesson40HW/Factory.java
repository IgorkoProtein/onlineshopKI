package kupchack.com.ua.lesson40HW;

public class Factory {
    public static void startfactory(ServiceFactory factory) {
        Service service = factory.createService();
        service.provideService();
    }
}
