package kupchack.com.ua.lesson24GenericsLimit.Coordinate;

public class Coordinates<T extends TwoDim> {
    private T[] coord;

    public Coordinates(T[] coord) {
        this.coord = coord;
    }

    public T[] getCoord() {
        return coord;
    }

    public void setCoord(T[] coord) {
        this.coord = coord;
    }
}
