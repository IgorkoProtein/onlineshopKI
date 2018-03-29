package kupchack.com.ua.AbstractFactory.Product;

public class RussianMainCourse implements MainCourse {
    @Override
    public void cut() {
        System.out.println(" cut in Russian ");
    }

    @Override
    public void bake() {
        System.out.println(" bake in Russian ");
    }
}
