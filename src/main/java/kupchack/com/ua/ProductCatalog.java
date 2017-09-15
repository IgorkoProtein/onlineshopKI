package kupchack.com.ua;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductCatalog {
    private static ArrayList<Product> products = Product.createArrayList();
    private static String pathToFile = "src/main/java/lesson12_GRASP/Data/productCatalog";

    public static void addProduct(String name, double price) {
        Product product = Product.create();
        product.setDescription(name);
        product.setPrice(price);
        products.add(product);
    }

    public static void showProducts() {
        System.out.println("\n\n");
        System.out.println("ID\t\tNAME\t\tPRICE");
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public static Product chooseProduct() {
        showProducts();
        Scanner temp = new Scanner(System.in);
        System.out.print("Choose product by index: ");
        int inputIndex = temp.nextInt();

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getItemID() == inputIndex) {
                inputIndex = i;
                break;
            }
        }
        return products.get(inputIndex);
    }

    public static void addProduct() {
        int condition = 1;
        String productName;
        double productPrice;

        do {
            Scanner input = new Scanner(System.in);
            System.out.println("\n\n");

            System.out.print("Please, enter name of product: ");
            productName = input.nextLine();

            System.out.print("Please, enter price of product: ");
            productPrice = input.nextDouble();

            addProduct(productName, productPrice);
            System.out.println("Do you want to add another product?");
            System.out.print("(1 - YES / 0 - NO) : ");
            condition = input.nextInt();
        } while (condition == 1);

        Serializator.saveData(pathToFile, products);
    }

    public static void loadProduct() {
        products = (ArrayList<Product>) Serializator.loadData(pathToFile);
    }

}
