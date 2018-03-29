package kupchack.com.ua.lesson40HW;

import kupchack.com.ua.lesson40.*;

public class Runner {
    public static void main(String[] args) {
        Factory.startfactory(new TruckServiceFactory());
        Factory.startfactory(new CarServiceFactory());
    }
}
