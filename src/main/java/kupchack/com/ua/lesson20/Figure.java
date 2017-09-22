package kupchack.com.ua.lesson20;

public class Figure {
    private double dimension1;
    private double dimension2;

    public Figure() {
        this.dimension1 = -1.1;
        this.dimension2 = -1.1;
    }

    public Figure(double dimension1, double dimension2) {
        this.dimension1 = dimension1;
        this.dimension2 = dimension2;
    }

    public double getDimension1() {
        return dimension1;
    }

    public void setDimension1(double dimension1) {
        this.dimension1 = dimension1;
    }

    public double getDimension2() {
        return dimension2;
    }

    public void setDimension2(double dimension2) {
        this.dimension2 = dimension2;
    }

    public double getArea(){
        System.out.printf("неможливо порахувати площу даної фігури");

        return 0;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "dimension1=" + dimension1 +
                ", dimension2=" + dimension2 +
                '}';
    }
}
