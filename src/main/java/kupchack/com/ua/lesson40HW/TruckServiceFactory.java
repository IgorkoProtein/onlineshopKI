package kupchack.com.ua.lesson40HW;

public class TruckServiceFactory implements ServiceFactory {
    @Override
    public Service createService() {
        return new ServiceTruck();
    }
}
