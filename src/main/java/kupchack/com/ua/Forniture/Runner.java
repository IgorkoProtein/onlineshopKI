package kupchack.com.ua.Forniture;

import java.util.Scanner;

public class Runner {
    private static Collectable factory;

    public static void setUpFurniture(String type) {
        if (type.equalsIgnoreCase("Chair")) {
            factory = new MakeChair();
        } else if (type.equalsIgnoreCase("Sofa")) {
            factory = new MakeSofa();
        } else if (type.equalsIgnoreCase("Table")) {
            factory = new MakeTable();
        } else {
            System.out.println("Wrong name of furniture");
        }
    }

    public static void runCollecting() {
        factory.makeFurniture();
    }

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        System.out.println("Enter name of furniture");
        String Furnitype = scaner.next();

        setUpFurniture(Furnitype);
        runCollecting();
    }
}
