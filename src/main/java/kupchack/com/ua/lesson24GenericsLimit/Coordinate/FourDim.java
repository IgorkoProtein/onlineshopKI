package kupchack.com.ua.lesson24GenericsLimit.Coordinate;

public class FourDim extends ThreeDim {
    private int t;

    public FourDim(int x, int y, int z, int t) {
        super(x, y, z);
        this.t = t;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }
}
