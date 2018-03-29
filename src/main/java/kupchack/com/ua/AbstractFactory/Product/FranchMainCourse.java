package kupchack.com.ua.AbstractFactory.Product;

public class FranchMainCourse implements MainCourse {
    @Override
    public void cut() {
        System.out.println(" cut in Franch ");
    }

    @Override
    public void bake() {
        System.out.println(" bake in Franch ");
    }
}
