package kupchack.com.ua.lesson40HW;

public class CarServiceFactory implements ServiceFactory {
    @Override
    public Service createService() {
        return new ServiceCar();
    }
}
