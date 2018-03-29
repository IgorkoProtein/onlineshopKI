package kupchack.com.ua.lesson40;

public class Runner{
    public static void main(String[] args) {
        Factory.startService(new BakeryServiceFactory());
        Factory.startService(new ServiceCoffeFactory());
    }
}
