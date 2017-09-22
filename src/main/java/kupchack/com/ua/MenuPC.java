package kupchack.com.ua;

import java.util.Scanner;

public class MenuPC {
        private static int choose = -1;

        public static void main(String[] args) {
            do {
                ProductCatalog.loadProduct();
                showMenu();
                choose = getMenuNumber();
                doAction(choose);
            } while (choose != 0);
        }

        public static void showMenu() {

            System.out.println("1 - Show product");
            System.out.println("2 - add product");
            System.out.println("3 - choose product");
            System.out.println("0 - Exit enter");
            System.out.println("          ");
        }

        public static int getMenuNumber() {
            Scanner input = new Scanner(System.in);
            int temp = -1;

            do {
                System.out.print("Enter menu's number : ");

                temp = input.nextInt();
            } while (temp < 0 || temp > 3);

            return temp;
        }

        public static void doAction(int choise) {
            switch (choise) {
                case 1:
                    ProductCatalog.showProducts();
                    break;
                case 2:
                    ProductCatalog.addProduct();
                case 3:
                    ProductCatalog.chooseProduct();
                    break;
                case 0:
                    System.exit(0);
            }
        }

    }


