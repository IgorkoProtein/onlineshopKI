package kupchack.com.ua.AbstractFactory.Client_Runner;

import kupchack.com.ua.AbstractFactory.Factory.CookingFactory;
import kupchack.com.ua.AbstractFactory.Product.Desert;
import kupchack.com.ua.AbstractFactory.Product.FirstCourse;
import kupchack.com.ua.AbstractFactory.Product.MainCourse;

public class ClientCitchen {
    private CookingFactory citchen;
    private FirstCourse soup;
    private MainCourse meat;
    private Desert pie;

    public ClientCitchen(CookingFactory citchen) {
        this.citchen = citchen;
        this.soup = citchen.cookFirstCourse();
        this.meat = citchen.cookMainCourse();
        this.pie = citchen.cookDesert();
    }

    public void cookSoup(){
        System.out.println("cookSoup");
        soup.chopOff();
        soup.boild();
    }

    public void cookMeat(){
        System.out.println("cookMeat");
        meat.cut();
        meat.bake();
    }

    public void cookPie(){
        System.out.println("cookPie");
        pie.substitute();
        pie.bake();
    }
}
