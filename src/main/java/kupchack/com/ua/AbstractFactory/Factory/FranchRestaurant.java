package kupchack.com.ua.AbstractFactory.Factory;

import kupchack.com.ua.AbstractFactory.Product.*;

public class FranchRestaurant implements CookingFactory {
    @Override
    public FirstCourse cookFirstCourse() {
        return new FranchSoup();
    }

    @Override
    public MainCourse cookMainCourse() {
        return new FranchMainCourse();
    }

    @Override
    public Desert cookDesert() {
        return new FranchDesert();
    }
}
