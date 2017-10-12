package kupchack.com.ua.lesson23.Homework;

import java.util.Scanner;

public class Chooser implements IChoose {
    public String choose() {

        String productName;
        Scanner input = new Scanner(System.in);
        System.out.println("Pleese enter your product :");
        productName = input.next();

        return productName;
    }

    //public String choose(String index) { return index;}
}
