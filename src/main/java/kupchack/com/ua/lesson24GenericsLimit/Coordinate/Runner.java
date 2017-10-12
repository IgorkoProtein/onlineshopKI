package kupchack.com.ua.lesson24GenericsLimit.Coordinate;

public class Runner {
    public static void main(String[] args) {
        TwoDim td[] = {new TwoDim(2, 4), new TwoDim(5, 3)};
        ThreeDim thd[] = {new ThreeDim(12,4, 5), new ThreeDim(3, 5, 8)};
        FourDim fd[]= {new FourDim(12, 34, 2, 5), new FourDim(3, 4, 8, 6)};

        Coordinates<TwoDim> tdc = new Coordinates<>(td);
        Coordinates<ThreeDim> thdc = new Coordinates<>(thd);
        Coordinates<FourDim> fdc = new Coordinates<>(fd);

        ShowCoordinates.showXY(tdc);
        ShowCoordinates.showXY(thdc);
        ShowCoordinates.showXY(fdc);

        ShowCoordinates.showXYZ(thdc);
        ShowCoordinates.showXYZ(fdc);

    }
}
