package kupchack.com.ua;

import java.time.LocalDate;
import java.time.Period;

public class User extends Person{
    private static int nextId = 1;
    private int userId;
    private String password;
    private String loginStatus;


    public User() {
        super();
        this.password = "-1";
        this.loginStatus = "-1";
        setUserId();
    }

    public User(String name, String surname, String password, String loginStatus) {
        super(name, surname);
        this.password = password;
        this.loginStatus = loginStatus;
        setUserId();
    }

    public User(String name, String surname, LocalDate birthDay, String password, String loginStatus) {
        super(name, surname, birthDay);
        this.password = password;
        this.loginStatus = loginStatus;
        setUserId();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
                ", loginStatus='" + loginStatus + '\'' +
                '}';
    }
}
