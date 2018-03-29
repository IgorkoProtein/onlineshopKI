package kupchack.com.ua.lesson40;

public class ServiceCoffeFactory implements ServiceFactory{
    @Override
    public Service createService() {
        return new ServiceCoffe();
    }
}
