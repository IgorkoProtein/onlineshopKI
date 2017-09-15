package kupchack.com.ua;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {

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

    @Override
    public String toString() {
        return itemID + "\t\t" + description + "\t\t" + price;
    }
}
