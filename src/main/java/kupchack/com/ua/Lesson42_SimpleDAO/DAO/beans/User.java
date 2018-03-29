package kupchack.com.ua.Lesson42_SimpleDAO.DAO.beans;

import kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic.Identificator;
import kupchack.com.ua.onlineShop.users.InputExceptoin;

import java.util.Scanner;

public class User implements Identificator<Integer>{
    private int userId;
    private String password;
    private String login;
    private String email;

    public String getEmail() {
        return email;
    }

    public User() {
        this.password = "-1";
        this.login = "-1";
        this.email = "-1";
        this.userId = -1;
    }

    public User(int userId, String password, String login, String email) {
        this.userId = userId;
        this.password = password;
        this.login = login;
        this.email = email;
    }

    public User(String login, String password,  String email) {
        this.password = password;
        this.login = login;
        this.email = email;
        this.userId = -1;

    }

    public Integer getId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public void setEmail(String email) {
        this.email = email;
    }



    public void setPassword(){
        String password = "0";
        Scanner input = new Scanner(System.in);
        do {
            try {
                System.out.println("Enter the eight digit password ");
                password = input.next();

                if (password.length() < 8 || password.length() > 20) {
                    throw new InputExceptoin("Неправильний діапазан введеняя");
                }
                break;
            } catch (InputExceptoin inputExceptoin) {
                System.out.println(inputExceptoin.getMessage());
                continue;
            }
        }while (true);

        this.password = password;
    }

    public void setLogin(){
        String login = "0";
        Scanner input = new Scanner(System.in);
        do {
            try {
                System.out.println("Enter the six digit password ");
                login = input.next();

                if (login.length() < 6 || login.length() > 20) {
                    throw new InputExceptoin("Неправильний діапазан введеняя");
                }
                break;
            } catch (InputExceptoin inputExceptoin) {
                System.out.printf(inputExceptoin.getMessage());
                continue;
            }
        }while (true);

        this.login = login;
    }

    public void setEmail(){
        String eMail = "1";
        //String [] nededSymbols = {".com", "@"};
        Scanner input = new Scanner(System.in);

        do {
            try {
                System.out.println("Введіть ваш eMail");
                eMail = input.next();

                if(!(eMail.contains(".com"))){
                    throw new InputExceptoin("eMail повиен містити .com");
                }else if(!(eMail.contains("@"))){
                    throw new InputExceptoin("eMail повиен містити @");
                }break;
            } catch (InputExceptoin inputExceptoin) {
                System.out.println(inputExceptoin.getMessage());
                continue;
            }
        } while (true);

        this.email = eMail;

    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", password='" + password + '\'' + ", login='" + login + '\'' + ", email='" + email + '\'' + '}';
    }
}
