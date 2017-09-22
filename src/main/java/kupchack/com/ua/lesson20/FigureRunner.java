package kupchack.com.ua.lesson20;

import java.util.ArrayList;

/**
 * Created by Home on 22.09.2017.
 */
public class FigureRunner {
    public static void main(String[] args) {

        ArrayList<Figure> figures = new ArrayList<Figure>();
        figures.add(new Rectangl(23.1, 43.2));
        figures.add(new Triangle(12.3, 23.3));

        for (Figure figur: figures) {
            figur.getArea();
        }
    }
}
