package kupchack.com.ua.AbstractFactory.Product;

public class RussianSoup implements FirstCourse {
    @Override
    public void chopOff() {
        System.out.println(" chop off in Russian ");
    }

    @Override
    public void boild() {
        System.out.println(" boild off in Russian ");
    }
}
