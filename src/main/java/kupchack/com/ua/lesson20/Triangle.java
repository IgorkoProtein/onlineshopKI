package kupchack.com.ua.lesson20;

/**
 * Created by Home on 22.09.2017.
 */
public class Triangle extends Figure{
    public Triangle(double dimension1, double dimension2) {
        super(dimension1, dimension2);
    }

    @Override
    public double getArea() {
        double result = (getDimension1() * getDimension2()) / 2;
        System.out.println("Площа трикутника = "+ result);
        return result;

    }
}
