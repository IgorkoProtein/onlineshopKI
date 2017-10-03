package kupchack.com.ua.onlineShop.users;

import java.time.LocalDate;
import java.util.ArrayList;

public class Administrator extends User {
    private String email;

    public Administrator(String email) {
        super();
        this.email = "none";
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void updateCatalog(boolean temp) {
    }


    public static ArrayList<Administrator> createArrayList(){return new ArrayList<Administrator>();}
}
