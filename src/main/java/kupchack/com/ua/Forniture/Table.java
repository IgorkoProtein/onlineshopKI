package kupchack.com.ua.Forniture;

public class Table implements Makeable {
    @Override
    public void loadSketch() {
        System.out.println("loadSketch for table");
    }

    @Override
    public void trim() {
        System.out.println("triming table");
    }

    @Override
    public void grind() {
        System.out.println("grinding table");
    }

    @Override
    public void varnish() {
        System.out.println("varnishing table");
    }

    @Override
    public void collect() {
        System.out.println("collecting table");
    }
}
