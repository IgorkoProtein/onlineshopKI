package kupchack.com.ua.onlineShop.users;

import java.util.Scanner;

public class ReadingData {
    private static Scanner input = new Scanner(System.in);


    public static String getData(String title) {
        System.out.print(title);
        return input.nextLine();
    }
}
