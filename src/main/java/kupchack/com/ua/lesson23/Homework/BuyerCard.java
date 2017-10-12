package kupchack.com.ua.lesson23.Homework;

import kupchack.com.ua.lesson23.Homework.IPay;

import java.util.Scanner;

public class BuyerCard implements IPay{

    public String payForProduct() {
        Scanner temp = new Scanner(System.in);
        System.out.printf("Enter your card ");
        String password = temp.next();

        return password;
    }
}
