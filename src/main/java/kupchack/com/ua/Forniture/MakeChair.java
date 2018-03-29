package kupchack.com.ua.Forniture;

public class MakeChair extends Collectable {
    @Override
    public Makeable collectFurniture() {
        return new Chair();
    }
}
