package kupchack.com.ua.AbstractFactory.Product;

public class ChineseSoup implements FirstCourse {
    @Override
    public void chopOff() {
        System.out.println(" chop off in chinese ");
    }

    @Override
    public void boild() {
        System.out.println(" boild in chinese ");
    }
}
