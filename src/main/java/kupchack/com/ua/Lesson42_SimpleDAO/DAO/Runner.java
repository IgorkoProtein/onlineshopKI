package kupchack.com.ua.Lesson42_SimpleDAO.DAO;

import kupchack.com.ua.Lesson42_SimpleDAO.DAO.MySQL.MySQLDAOFactory;
import kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic.DAOException;
import kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic.GenericDAO;
import kupchack.com.ua.Lesson42_SimpleDAO.DAO.beans.Person;

import java.util.List;
import java.util.Scanner;

public class Runner {
   /*  private static MySQLDAOFactory  factory = new MySQLDAOFactory();
    private static GenericDAO dao;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


       try {
            reConnect();
            List<Person> personList = dao.readAll();

            for (Person person : personList) {
                System.out.println(person.toString());
            }

            System.out.print("Please choose id: ");
            int id = scanner.nextInt();
            reConnect();
            Person somePerson = (Person) dao.read(id);

            somePerson.setName();
            reConnect();
            dao.update(somePerson);

            reConnect();
            personList = dao.readAll();

            for (Person person : personList) {
                System.out.println(person.toString());
            }

            //Person person = new Person("Ivan", "Theodorovych", LocalDate.now());
            //Person person1 = (Person) dao.create(person);

            //System.out.println(person1.toString());


        } catch (DAOException e) {
            e.printStackTrace();
        }

    }


    public static void reConnect()throws DAOException {
        dao = factory.getDAO(factory.getConnection(), Person.class);
    }
    */
   public static void main(String[] args) {
       WorkWithUsers.readAllUsers();
       //WorkWithUsers.createUser();
       //WorkWithUsers.updateUser();
       WorkWithUsers.deleteUser();
   }
}
