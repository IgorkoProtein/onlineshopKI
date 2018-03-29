package kupchack.com.ua.Lesson42_SimpleDAO.DAO.MySQL;

import kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic.DAOException;
import kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic.DAOFactory;
import kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic.GenericDAO;
import kupchack.com.ua.Lesson42_SimpleDAO.DAO.beans.MuscleGroup;
import kupchack.com.ua.Lesson42_SimpleDAO.DAO.beans.Person;
import kupchack.com.ua.Lesson42_SimpleDAO.DAO.beans.Users;
import kupchack.com.ua.lesson36_jdbc_crud_person.PersonCRUD;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MySQLDAOFactory implements DAOFactory<Connection> { /*
1 створити два посилання на фабрику і на dao
2 (викликати фабрику і у фабриці викликати getpersondao )отримати dao
 */

    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DATA_BASE = "jdbc:mysql://127.0.0.1:3306/online_shop";
    private final String LOGIN = "IgorKupchack";
    private final String PASSWORD = "igorko777";
    private final Logger log = Logger.getLogger(PersonCRUD.class);
    private Map<Class, CreatorDAO> daos;

    public MySQLDAOFactory() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            log.error("Cannot find driver");
            e.printStackTrace();
        }


        daos = new HashMap<Class, CreatorDAO>();
        daos.put(Person.class, new CreatorDAO<Connection>() {
            @Override
            public GenericDAO createDAO(Connection connection) {
                return new PersonDao(connection);
            }
        });

        daos.put(MuscleGroup.class, new CreatorDAO<Connection>() {
            @Override
            public GenericDAO createDAO(Connection connection) {
                return new MuscleDAO(connection);
            }
        });

        daos.put(Users.class, new CreatorDAO<Connection>() {
            @Override
            public GenericDAO createDAO(Connection connection) {
                return new UsersDao(connection);
            }
        });


    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            log.info("Connecting to dataBase... ");
            connection = DriverManager.getConnection(DATA_BASE, LOGIN, PASSWORD);
        } catch (SQLException e) {
            log.error("Cannot get connection ");
            log.error(e.getStackTrace());
        }
        return connection;
    }

    @Override
    public GenericDAO getDAO(Connection connection, Class daoClass) throws DAOException {
        CreatorDAO creator = daos.get(daoClass);

        if (creator == null){
            throw  new DAOException("Can't find dao for "+ daoClass);
        }
        return creator.createDAO(connection);
    }

}
