package kupchack.com.ua.lesson24GenericsLimit.Coordinate;

public class ShowCoordinates {
    public static void showXY(Coordinates<?> obj){
        System.out.println("X : Y");
        for (int i = 0; i < obj.getCoord().length; i++) {
            System.out.println(obj.getCoord()[i].getX() + " : " + obj.getCoord()[i].getY());
        }
    }

    public static void showXYZ(Coordinates<? extends ThreeDim> obj) {
        System.out.println("X : Y : Z");
        for (int i = 0; i < obj.getCoord().length; i++) {
            System.out.println(obj.getCoord()[i].getX() + " : " + obj.getCoord()[i].getY() + " : " + obj.getCoord()[i].getZ());
        }
    }
    }
