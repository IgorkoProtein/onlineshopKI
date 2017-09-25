package kupchack.com.ua.onlineShop.users;

import java.time.LocalDate;
import java.time.Period;

public class User extends Person{
    private static int nextId = 1;
    private int userId;
    private String password;
    private String login;
    private String email;


    public User() {
        super();
        this.password = "-1";
        this.login = "-1";
        this.email = "-1";
        setUserId();
    }

    public User(String name, String surname, int userId, String password, String login, String email) {
        super(name, surname);
        this.userId = userId;
        this.password = password;
        this.login = login;
        this.email = email;
    }

    public User(String name, String surname, LocalDate birthDay, int userId, String password, String login, String email) {
        super(name, surname, birthDay);
        this.userId = userId;
        this.password = password;
        this.login = login;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        User.nextId = nextId;
    }

    public void setUserId(){
        userId = nextId;
        nextId++;
    }

    public int getAge() {

        LocalDate now = LocalDate.now();
        Period age = Period.between(getBirthDay(),now);
        return Integer.getInteger(age.toString());
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name="+ super.getName()+
                ", surname="+ super.getSurname()+
                ", birthday="+ super.getBirthDay()+
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
