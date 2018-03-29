package kupchack.com.ua.Forniture;

public class Chair implements Makeable {
    @Override
    public void loadSketch() {
        System.out.println("loadSketch for chair");
    }

    @Override
    public void trim() {
        System.out.println("triming chair");
    }

    @Override
    public void grind() {
        System.out.println("grinding chair");
    }

    @Override
    public void varnish() {
        System.out.println("varnishing chair");
    }

    @Override
    public void collect() {
        System.out.println("collecting chair");
    }
}
