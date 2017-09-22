package kupchack.com.ua.lesson20;

public class Rectangl extends Figure {
    public Rectangl(double dimension1, double dimension2) {
        super(dimension1, dimension2);
    }

    @Override
    public double getArea() {
        double result = getDimension1() * getDimension2();
        System.out.println("Площа прямокутнику = "+ result);
        return result;
    }
}
