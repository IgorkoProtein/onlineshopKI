package kupchack.com.ua.AbstractFactory.Factory;

import kupchack.com.ua.AbstractFactory.Product.*;

public class ChineseRestaurant implements CookingFactory {
    @Override
    public FirstCourse cookFirstCourse() {
        return new ChineseSoup();
    }

    @Override
    public MainCourse cookMainCourse() {
        return new ChineseMainCourse();
    }

    @Override
    public Desert cookDesert() {
        return new ChineseDesert();
    }
}
