package kupchack.com.ua.Lesson42_SimpleDAO.DAO.beans;

import kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic.Identificator;
import kupchack.com.ua.onlineShop.users.InputExceptoin;

import java.util.Scanner;

public class Users implements Identificator<Integer> {
    private int userId;
    private String login;
    private String password;

    public Users() {
        this.userId = 0;
        this.login = "login";
        this.password = "password";
    }

    public Users(int userId, String login, String password) {
        this.userId = userId;
        this.login = login;
        this.password = password;
    }

    public Users(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Integer getId() {
        return userId;
    }

    protected void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPassword(){
        String password = "0";
        Scanner input = new Scanner(System.in);
        do {
            try {
                System.out.println("Enter a password range from 10 to 30 characters: ");
                password = input.next();

                if (password.length() < 10 || password.length() > 30) {
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
                System.out.println("Enter a login range from 9 to 30 characters: ");
                login = input.next();

                if (login.length() < 9 || login.length() > 30) {
                    throw new InputExceptoin("Неправильний діапазан введеняя");
                }
                break;
            } catch (InputExceptoin inputExceptoin) {
                System.out.printf(inputExceptoin.getMessage());
            }
        }while (true);

        this.login = login;
    }

    @Override
    public String toString() {
        return "Users{" + "userId=" + userId + ", login='" + login + '\'' + ", password='" + password + '\'' + '}';
    }
}
