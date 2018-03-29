package kupchack.com.ua.Forniture;

public class Sofa implements Makeable {
    @Override
    public void loadSketch() {
        System.out.println("loadSketch for sofa");
    }

    @Override
    public void trim() {
        System.out.println("triming sofa");
    }

    @Override
    public void grind() {
        System.out.println("grinding sofa");
    }

    @Override
    public void varnish() {
        System.out.println("varnishing sofa");
    }

    @Override
    public void collect() {
        System.out.println("collecting sofa");
    }
}
