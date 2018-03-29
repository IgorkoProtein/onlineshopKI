package kupchack.com.ua.Forniture;

public abstract class Collectable {
    public abstract Makeable collectFurniture();

    public void makeFurniture(){
        Makeable furniture = collectFurniture();
        furniture.loadSketch();
        furniture.trim();
        furniture.grind();
        furniture.varnish();
        furniture.collect();
    };

}
