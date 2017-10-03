package kupchack.com.ua.onlineShop.users;

import java.util.ArrayList;

public class Autorisation {
    private static ArrayList<Customer> customers = Customer.createArrayList();
    private static ArrayList<Administrator> administrators = Administrator.createArrayList();

    public static void CustomerRegistration(){
        Customer obj = new Customer();
        obj.setName("");

    }

    public static void main(String[] args) {
        Customer obj = new Customer();
        obj.setName();
        obj.setSurname();
        obj.setBirthday();

        obj.setLogin();
        obj.setPassword();
        obj.setEmail();

        System.out.println( obj.toString());


    }
}
