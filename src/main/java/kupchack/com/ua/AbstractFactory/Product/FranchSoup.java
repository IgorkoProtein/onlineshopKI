package kupchack.com.ua.AbstractFactory.Product;

public class FranchSoup implements FirstCourse {
    @Override
    public void chopOff() {
        System.out.println(" chop off in Franch ");
    }

    @Override
    public void boild() {
        System.out.println(" boild off in Franch ");
    }
}
