package kupchack.com.ua.Lesson42_SimpleDAO.DAO;

import com.sun.org.apache.xpath.internal.SourceTree;
import kupchack.com.ua.Lesson42_SimpleDAO.DAO.MySQL.MySQLDAOFactory;
import kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic.DAOException;
import kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic.GenericDAO;
import kupchack.com.ua.Lesson42_SimpleDAO.DAO.beans.Users;
import kupchack.com.ua.onlineShop.users.ReadingData;

import java.util.List;

import static kupchack.com.ua.Lesson42_SimpleDAO.DAO.WorkWithPerson.reConnect;

public class WorkWithUsers {
    public static MySQLDAOFactory factory = new MySQLDAOFactory();
    public static GenericDAO dao;

    public static int getUserId(){
        readAllUsers();
        return  ReadingData.getIntData("Please choose id: ");
    }

    public static void readAllUsers(){
        try {
            reConnect();
            List<Users> users = dao.readAll();
            for (Users us :users) {
                System.out.println(us.toString());
            }
            System.out.println(" ");
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public static void createUser() {
        try {
            reConnect();
            Users user = new Users();
            user.setLogin();
            user.setPassword();
            dao.create(user);
            System.out.println(user.toString() + " was created");
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser() {
        try {
            reConnect();
            List<Users> users = dao.readAll();
            for (Users us : users) {
                if (us.getId() == getUserId()) {
                    dao.delete(us);
                    break;
                }
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public static void updateUser() {
        try {
            reConnect();
            Users someUsers = (Users) dao.read(getUserId());
            System.out.println(someUsers.toString());
            someUsers.setLogin();
            someUsers.setPassword();
            reConnect();
            dao.update(someUsers);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public static void reConnect() throws DAOException {
        dao = factory.getDAO(factory.getConnection(), Users.class);
    }
}
