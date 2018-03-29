package kupchack.com.ua.lesson36_jdbc_crud_person;

import org.apache.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonCRUD {
   /* private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATA_BASE = "jdbc:mysql://127.0.0.1:3306/online_shop";
    private static final String LOGIN = "IgorKupchack";
    private static final String PASSWORD = "igorko777";
    private static final Logger log = Logger.getLogger(PersonCRUD.class);


    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            log.info("Connecting to dataBase... ");
            connection = DriverManager.getConnection(DATA_BASE, LOGIN, PASSWORD);
        } catch (ClassNotFoundException e) {
            log.error("Cannot load class for driver ");
            log.error(e.getStackTrace());
        } catch (SQLException e) {
            log.error("Cannot get connection ");
            log.error(e.getStackTrace());
        }
        return connection;

    }

    public static void createPerson(Person pr) {
        Connection connection = null;
        PreparedStatement statement = null;

        String sql_query = "INSERT INTO persons (name, surname, born_date) VALUES (?, ?, ?)";

        try {
            log.info("Getting connection for create");
            connection = getConnection();

            log.info("Getting statement for INSERT query");
            statement = connection.prepareStatement(sql_query);

            statement.setString(1, pr.getName());
            statement.setString(2, pr.getSurname());
            statement.setDate(3, Date.valueOf(pr.getBirthDay()));

            int count = statement.executeUpdate();
            if (count == 1) {
                System.out.println("person was created");
                log.info("person was created");
            }else throw new SQLException("Created more than one record");

        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Cannot create new person ");
            log.error(e.getStackTrace());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException obj) {
                log.error("Error connection closing in createPerson method");
                log.error(obj.getStackTrace());
            }

        }
    }

    public static void deletePerson(Person person) {
        Connection connection = null;
        PreparedStatement statement = null;

        String sql_query = "DELETE FROM persons WHERE person_id = ?";

        try {
            connection = getConnection();
            log.info("Getting statement for DELETE query");
            statement = connection.prepareStatement(sql_query);
            statement.setInt(1, person.getId());

            int count = statement.executeUpdate();
            if (count == 1) {
                System.out.println("person was deleted");
                log.info("person was deleted");
            }


        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Cannot delete person ");
            log.error(e.getStackTrace());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException obj) {
                log.error("Error during connection closing ");
                log.error(obj.getStackTrace());
            }
        }
    }

    public static void getUsers(){
        Connection connection = null;
        Statement statement = null;

        String sql_query = "SELECT* FROM persons";

        try {
            connection = getConnection();
            log.info("Getting statement");
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(sql_query);

            System.out.println("ID\tNAME\t\tSURNAME\tBIRTHDAY\tCREATED\t\tUPDATED");

            while(rs.next()){
                int id = rs.getInt("person_id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                LocalDate date = rs.getDate("born_date").toLocalDate();
                LocalDate created = rs.getDate("created").toLocalDate();
                LocalDate updated = rs.getDate("updated").toLocalDate();

                System.out.println(id + "\t" + name + "\t\t" + surname + "\t" + date + "\t" + created + "\t" + updated);
            }
            System.out.println();

        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Cannot get all persons ");
            log.error(e.getStackTrace());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException obj) {
                log.error("Error during connection closing ");
                log.error(obj.getStackTrace());
            }
        }
    }

    public static Person getPerson(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ArrayList<Person> persons = new ArrayList<>();

        String sql_query = "SELECT* FROM persons WHERE person_id = ?";

        try {
            log.info("Getting connection for get user");
            connection = getConnection();
            log.info("Getting statement for get user");
            statement = connection.prepareStatement(sql_query);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                int p_id = rs.getInt("person_id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                LocalDate date = rs.getDate("born_date").toLocalDate();
                persons.add(new Person(p_id, name, surname, date));
            }

            if (persons.size() != 1){
                throw new SQLException("We got more than one record");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Cannot get person");
            log.error(e.getStackTrace());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException obj) {
                log.error("Error during connection closing in getPerson method");
                log.error(obj.getStackTrace());
            }
        }
        return persons.get(0);
    }

    public static void updatePerson(Person person, int perId) {
        Connection connection = null;
        PreparedStatement statement = null;

        String sql_query = "UPDATE persons SET name =  ? , surname =  ?, born_date = ? WHERE person_id =  ?;";

        try {
            log.info("Getting connection for update query");
            connection = getConnection();
            log.info("Getting preparestatement for update query");
            statement = connection.prepareStatement(sql_query);

            statement.setString(1, person.getName());
            statement.setString(2, person.getSurname());
            statement.setDate(3, Date.valueOf(person.getBirthDay()));
            statement.setInt(4, perId);

            int count = statement.executeUpdate();
            if (count == 1) {
                System.out.println("person was updated");
                log.info("person was updated");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Cannot update person ");
            log.error(e.getStackTrace());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException obj) {
                log.error("Error during connection closing in person update method");
                log.error(obj.getStackTrace());
            }
        }
    }*/


}
