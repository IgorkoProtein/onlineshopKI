package kupchack.com.ua;

import java.time.LocalDate;
import java.util.ArrayList;

public class Customer extends User{
    private String address;
    private String email;
    private String creditCardInfo;
    private String shoppingInfo;
    private ArrayList<ShoppingCard> ShopCard;


    public Customer() {
        this.address = "none";
        this.email = "none";
        this.creditCardInfo = "none";
        this.shoppingInfo = "none";
        ShopCard = new ArrayList<ShoppingCard>();  // Чому в оголошенні ліста не використовуємо new ?
    }

    public Customer(String name, String surname, LocalDate birthDay, String password, String loginStatus, String address, String email, String creditCardInfo, String shoppingInfo) {
        super(name, surname, birthDay, password, loginStatus);
        this.address = address;
        this.email = email;
        this.creditCardInfo = creditCardInfo;
        this.shoppingInfo = shoppingInfo;
        ShopCard = new ArrayList<ShoppingCard>();
    }

    public Customer(String name, String surname, String password, String loginStatus, String address, String email, String creditCardInfo, String shoppingInfo) {
        super(name, surname, password, loginStatus);
        this.address = address;
        this.email = email;
        this.creditCardInfo = creditCardInfo;
        this.shoppingInfo = shoppingInfo;
        ShopCard = new ArrayList<ShoppingCard>();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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


}
