package kupchack.com.ua.AbstractFactory.Client_Runner;

import kupchack.com.ua.AbstractFactory.Factory.ChineseRestaurant;
import kupchack.com.ua.AbstractFactory.Factory.FranchRestaurant;
import kupchack.com.ua.AbstractFactory.Factory.RussianRestaurant;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ClientCitchen cuisine = null;
        Scanner Scaner = new Scanner(System.in);

        System.out.println("Choise you favorite citchen ");

        System.out.println(" 1 - Chinese ");
        System.out.println(" 2 - Franch ");
        System.out.println(" 3 - Russian ");
        System.out.println("-> ");

        int choise = Scaner.nextInt();

        switch (choise){
            case 1:
                cuisine = new ClientCitchen(new ChineseRestaurant());
                break;
            case 2:
                cuisine = new ClientCitchen(new FranchRestaurant());
                break;
            case 3:
                cuisine = new ClientCitchen(new RussianRestaurant());
                break;
        }

        cuisine.cookSoup();
        cuisine.cookMeat();
        cuisine.cookPie();
    }
}
