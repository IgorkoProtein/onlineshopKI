package kupchack.com.ua.Forniture;

public class MakeSofa extends Collectable {
    @Override
    public Makeable collectFurniture() {
        return new Sofa();
    }
}
