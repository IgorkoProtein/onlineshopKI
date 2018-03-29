package kupchack.com.ua.Forniture;

public class MakeTable extends Collectable {
    @Override
    public Makeable collectFurniture() {
        return new Table();
    }
}
