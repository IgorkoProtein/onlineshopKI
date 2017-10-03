package kupchack.com.ua.onlineShop.users;

import kupchack.com.ua.Order;
import kupchack.com.ua.ShoppingCard;

import java.time.LocalDate;
import java.util.ArrayList;

public class Customer extends User{
    private String address;
    private String creditCardInfo;
    private String shoppingInfo;
    private ArrayList<Order> orders;
    private ArrayList<ShoppingCard> ShopCard;



    public Customer() {
        this.address = "none";
        this.creditCardInfo = "none";
        this.shoppingInfo = "none";
        ShopCard = ShoppingCard.createArrayList(); // Чому в оголошенні ліста не використовуємо new ?
        orders = Order.createArrayList();
    }

    public Customer(String name, String surname, LocalDate birthDay,
                    int userId, String password, String login, String email,
                    String address, String creditCardInfo, String shoppingInfo) {
        super(name, surname, birthDay, userId, password, login, email);
        this.address = address;
        this.creditCardInfo = creditCardInfo;
        this.shoppingInfo = shoppingInfo;
    }

    public Customer(String name, String surname,
                    int userId, String password, String login,
                    String email, String address, String creditCardInfo, String shoppingInfo) {
        super(name, surname, userId, password, login, email);
        this.address = address;
        this.creditCardInfo = creditCardInfo;
        this.shoppingInfo = shoppingInfo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreditCardInfo() {
        return creditCardInfo;
    }

    public void setCreditCardInfo(String creditCardInfo) {
        this.creditCardInfo = creditCardInfo;
    }

    public String getShoppingInfo() {
        return shoppingInfo;
    }

    public void setShoppingInfo(String shoppingInfo) {
        this.shoppingInfo = shoppingInfo;
    }

    public static ArrayList<Customer> createArrayList(){return new ArrayList<Customer>();}


}
