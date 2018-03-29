package kupchack.com.ua.Lesson42_SimpleDAO.DAO;

import kupchack.com.ua.Lesson42_SimpleDAO.DAO.MySQL.MySQLDAOFactory;
import kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic.DAOException;
import kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic.GenericDAO;
import kupchack.com.ua.Lesson42_SimpleDAO.DAO.beans.Person;
import kupchack.com.ua.onlineShop.users.ReadingData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkWithPerson {
    private static MySQLDAOFactory factory = new MySQLDAOFactory();
    private static GenericDAO dao;

    public static int getPersonId(){
        readAllPersons();
        return  ReadingData.getIntData("Please choose id: ");
    }

    public static void readAllPersons() {
        try {
            reConnect();
            List<Person> persons = dao.readAll();
            for (Person person : persons) {
                System.out.println(person.toString());
            }
            System.out.println(" ");
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public static void createPerson() {
        try {
            reConnect();
            Person person = new Person();
            person.setName();
            person.setSurname();
            person.setBirthday();
            dao.create(person);
            System.out.println(person.toString() + " was created");
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public static void deletePerson() {
        try {
            reConnect();
            List<Person> persons = dao.readAll();
            for (Person per : persons) {
                if (per.getId() == getPersonId()) {
                    dao.delete(per);
                    break;
                }
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public static void updatePerson() {
        try {
            reConnect();
            Person somePerson = (Person) dao.read(getPersonId());
            System.out.println(somePerson.toString());
            somePerson.setName();
            somePerson.setSurname();
            somePerson.setBirthday();
            reConnect();
            dao.update(somePerson);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public static void reConnect() throws DAOException {
        dao = factory.getDAO(factory.getConnection(), Person.class);
    }
}


/*
ГОЛОВНЕ МЕНЮ
Щоденник тренувань
статистика моїх розмірів
нове тренування
Планувальник
Види вправ



1. Авторизація
2. Виклик головного меню


 */
