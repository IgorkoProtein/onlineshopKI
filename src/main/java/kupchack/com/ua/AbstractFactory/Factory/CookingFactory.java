package kupchack.com.ua.AbstractFactory.Factory;

import kupchack.com.ua.AbstractFactory.Product.Desert;
import kupchack.com.ua.AbstractFactory.Product.FirstCourse;
import kupchack.com.ua.AbstractFactory.Product.MainCourse;

public interface CookingFactory {
    public FirstCourse cookFirstCourse();
    public MainCourse cookMainCourse();
    public Desert cookDesert();
}
