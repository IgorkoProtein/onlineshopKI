package kupchack.com.ua.onlineShop.users;

import java.util.ArrayList;

public class Autorisation {
    private static ArrayList<Customer> customers = Customer.createArrayList();
    private static ArrayList<Administrator> administrators = Administrator.createArrayList();

    public static void CustomerRegistration(){
        Customer obj = new Customer();
        obj.setName("");

    }
}
