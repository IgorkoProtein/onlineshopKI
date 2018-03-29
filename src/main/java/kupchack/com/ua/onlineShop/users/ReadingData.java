package kupchack.com.ua.onlineShop.users;

import java.util.Scanner;

public class ReadingData {

    public static String getStringData(String title) {
        Scanner input = new Scanner(System.in);
        System.out.print(title + " -> ");
        return input.nextLine();
    }

    public static int getIntData(String title) {
        Scanner input = new Scanner(System.in);
        System.out.print(title + " -> ");
        return input.nextInt();
    }
}
