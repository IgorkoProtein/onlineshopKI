package kupchack.com.ua.lesson40;

public class BakeryServiceFactory implements ServiceFactory {
    @Override
    public Service createService() {
        return new ServiseBakery();
    }
}
