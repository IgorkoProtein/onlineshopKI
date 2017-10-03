package kupchack.com.ua;

import kupchack.com.ua.onlineShop.users.InputExceptoin;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.*;

public class Product implements Serializable {

    private static final Logger log = Logger.getLogger(Product.class);
    private String description;
    private double price;
    private int itemID;
    private static int nextID = 1;
    private static final long serialVersionUID = 1L;

    public Product() {
        this.description = " ";
        this.price = price;
        setItemID();
    }

    public Product(String description, double price, int itemID) {
        this.description = description;
        this.price = price;
        this.itemID = itemID;
    }

    public Product(String description, double price) {
        this.description = description;
        this.price = price;
        setItemID();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public void setItemID() {
        this.itemID = nextID;
        nextID++;
    }

    public static Product create() {
        return new Product();
    }

    public static ArrayList<Product> createArrayList() {
        return new ArrayList<Product>();
    }

    public void setDescription() {
        Scanner input = new Scanner(System.in);
        do {

            try {
                System.out.println("Enter description of product");
                String description = input.next();
                if (description.length() < 5) {
                    throw new InputExceptoin("Занадто малий опис продукту");
                }
                if (description.length() > 30) {
                    throw new InputExceptoin("Занадто великий опис ");
                }
                System.out.println(description);
                break;
            } catch (InputExceptoin inputExceptoin) {
                System.out.printf(inputExceptoin.getMessage());
                System.out.printf(String.valueOf(inputExceptoin.getClass()));
                continue;
            }
        } while (true);

    }


    public void setDescription2() {
        Scanner input = new Scanner(System.in);
        String description = "";
        String[] deniedSymbols = {"1", "2", "3"};
        boolean finishEntering  =true;

        do {
            System.out.println("Enter description of product: ");
            description = input.next();

            for (int i = 0; i < deniedSymbols.length; i++) {
                if (description.contains(deniedSymbols[i])) {
                    System.out.println("Введіть опис без цифр: ");
                    finishEntering = true;
                    break;
                }
                finishEntering = false;
            }

        } while (finishEntering);

        System.out.println(description);
    }

    public void setPrice() {
        Scanner input = new Scanner(System.in);
        do {
            try {
                System.out.print("Enter price of product: ");
                double price = input.nextFloat();
                if (price < 0 || price > 99000) {
                    throw new InputExceptoin("Неправильний діапазон введеної цін ");
                }

                this.price = price;
                log.info("Встановлена ціна продукту " + this.itemID + " = " + price);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Сталася помилка введеня :" + e.getClass());
                log.error("Сталася помилка введеня :" + e.getClass());
                log.error(e.getStackTrace());
                input.nextLine();
                continue;
            } catch (InputExceptoin inputExceptoin) {
                System.out.println(inputExceptoin.getMessage());
                log.error("Сталася помилка введеня :" + inputExceptoin.getMessage());
                log.error(inputExceptoin.getStackTrace());
                continue;
            }
        } while (true);

    }

    public static void main(String[] args) {
        Product product = new Product();

        //product.setPrice();
        product.setDescription2();


    }


    @Override
    public String toString() {
        return itemID + "\t\t" + description + "\t\t" + price;
    }
}
