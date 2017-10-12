package kupchack.com.ua.lesson24GenericsLimit.Coordinate;

public class ThreeDim extends TwoDim{
    private int z;

    public ThreeDim(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
