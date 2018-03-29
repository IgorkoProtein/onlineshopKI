package kupchack.com.ua.AbstractFactory.Product;

public class ChineseDesert implements Desert {
    @Override
    public void substitute() {
        System.out.println(" substitute in chinese ");
    }

    @Override
    public void bake() {
        System.out.println(" bake in chinese ");
    }
}
