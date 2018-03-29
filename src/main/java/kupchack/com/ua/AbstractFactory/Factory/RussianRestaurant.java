package kupchack.com.ua.AbstractFactory.Factory;

import kupchack.com.ua.AbstractFactory.Product.*;

public class RussianRestaurant implements CookingFactory {
    @Override
    public FirstCourse cookFirstCourse() {
        return new RussianSoup();
    }

    @Override
    public MainCourse cookMainCourse() {
        return new RussianMainCourse();
    }

    @Override
    public Desert cookDesert() {
        return new RussianDesert();
    }
}
