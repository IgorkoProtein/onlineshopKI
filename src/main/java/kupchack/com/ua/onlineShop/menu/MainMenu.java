package kupchack.com.ua.onlineShop.menu;

import kupchack.com.ua.ProductCatalog;
import org.apache.log4j.Logger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    private final static Logger log = Logger.getLogger(MainMenu.class);

    private static void showMenu() {
        System.out.println("1 - Show product catalog ");
        System.out.println("2 - Login ");
        System.out.println("3 - Registration ");
        System.out.println("0 - Exit ");
    }

    public static void main(String[] args) {
        do {
            showMenu();
            doAction(chooseMenu());
        } while (true);
    }

    private static int chooseMenu() {
        Scanner input = new Scanner(System.in);
        int temp = -1;

        do {
            try {
                System.out.print("Enter menu's number : ");
                temp = input.nextInt();

                if (temp < 0 || temp > 2) throw new RuntimeException("Введено неіснуючий пункт меню");
            } catch (InputMismatchException e) {
                log.error("Неправильно введений символ");
                System.out.println("Неправильно введений символ");
                input.nextLine();
                continue;
            } catch (RuntimeException e) {
                log.error(e.getMessage());
                System.out.println(e.getMessage());
                continue;
            }
            break;
        } while (true);

        return temp;
    }

    private static void doAction(int menuNumber) {
        switch (menuNumber) {
            case 1:
                //ProductCatalog.showProducts();
                break;
            case 2:
                ProductCatalog.addProduct();
            case 3:
                break;
            case 0:
                System.exit(0);
        }
    }


}
