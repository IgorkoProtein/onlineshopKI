package kupchack.com.ua.AbstractFactory.Product;

public class RussianDesert implements Desert {
    @Override
    public void substitute() {
        System.out.println(" substitute in Russian ");
    }

    @Override
    public void bake() {
        System.out.println(" bake in Russian ");
    }
}
