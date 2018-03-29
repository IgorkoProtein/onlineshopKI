package kupchack.com.ua.Lesson42_SimpleDAO.DAO.MySQL;

import kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic.AbstractDAO;
import kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic.DAOException;
import kupchack.com.ua.Lesson42_SimpleDAO.DAO.beans.Person;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonDao extends AbstractDAO<Person, Integer> {

    private class PersonForDAO extends Person{
        @Override
        public void setId(int id) {
            super.setId(id);
        }
    }


    public PersonDao(Connection connection) {
        super(connection);
    }

    @Override
    public Person create() throws DAOException {
        Person person = new Person();
        return create(person);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT* FROM persons ";
    }

    @Override
    public String getUpdateQuery() {
        return  "UPDATE persons SET name =  ? , surname =  ?, born_date = ? WHERE person_id =  ?";
    }

    @Override
    public String getDeleteQuery() {
       return "DELETE FROM persons WHERE person_id = ?";
    }

    @Override
    public String getInsertQuery() {
        return "INSERT INTO persons (name, surname, born_date) VALUES (?, ?, ?)";
    }

    @Override
    public String getWhereQuery() {
        return " WHERE person_id = ";
    }

    @Override
    public List<Person> parseResultSet(ResultSet res) throws DAOException {
        List<Person> persons = new ArrayList<>();
        try {
            while(res.next()){
                int p_id = res.getInt("person_id");
                String name = res.getString("name");
                String surname = res.getString("surname");
                LocalDate date = res.getDate("born_date").toLocalDate();
                persons.add(new Person(p_id, name, surname, date));
               /* PersonForDAO pr1 = new PersonForDAO();
                pr1.setId(p_id);
                persons.add(pr1);*/
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return persons;
    }

    @Override
    public void setStatementForUpdate(Person obj, PreparedStatement statement) throws DAOException {
        try {
            statement.setString(1, obj.getName());
            statement.setString(2, obj.getSurname());
            statement.setDate(3, Date.valueOf(obj.getBirthDay()));
            statement.setInt(4, obj.getId());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void setStatementForInsert(Person obj, PreparedStatement statement) throws DAOException {
        try {
            statement.setString(1, obj.getName());
            statement.setString(2, obj.getSurname());
            statement.setDate(3, Date.valueOf(obj.getBirthDay()));
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void setStatementForDelete(Person obj, PreparedStatement statement) throws DAOException {
        try {
            statement.setInt(1, obj.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
