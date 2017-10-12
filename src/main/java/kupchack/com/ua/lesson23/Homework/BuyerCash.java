package kupchack.com.ua.lesson23.Homework;

import java.util.Scanner;

public class BuyerCash implements IPay {
    public String payForProduct() {
        Scanner temp = new Scanner(System.in);
        System.out.printf("Give my yor money :");
        String money = temp.next();

        return money;
    }
}
