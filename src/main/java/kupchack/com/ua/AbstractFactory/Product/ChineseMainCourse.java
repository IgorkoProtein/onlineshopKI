package kupchack.com.ua.AbstractFactory.Product;

public class ChineseMainCourse implements MainCourse {
    @Override
    public void cut() {
        System.out.println(" cut in chinese ");
    }

    @Override
    public void bake() {
        System.out.println(" bake in chinese ");
    }
}
