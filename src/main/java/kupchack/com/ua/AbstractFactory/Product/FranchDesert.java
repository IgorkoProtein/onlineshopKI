package kupchack.com.ua.AbstractFactory.Product;

public class FranchDesert implements Desert {
    @Override
    public void substitute() {
        System.out.println(" substitute in Franch ");
    }

    @Override
    public void bake() {
        System.out.println(" bake in Franch ");
    }
}
