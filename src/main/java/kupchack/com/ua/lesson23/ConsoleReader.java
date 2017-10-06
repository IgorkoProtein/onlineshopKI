package kupchack.com.ua.lesson23;

import java.util.Scanner;

public class ConsoleReader implements IRead {
    public String readInformatoin() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your line of text :");
        String info = input.next();
        return info;
    }
}
