package kupchack.com.ua.Lesson42_SimpleDAO.DAO.MySQL;

import kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic.AbstractDAO;
import kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic.DAOException;
import kupchack.com.ua.Lesson42_SimpleDAO.DAO.beans.Users;

import javax.jws.soap.SOAPBinding;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDao extends AbstractDAO<Users, Integer>{
    public UsersDao(Connection connection) {
        super(connection);
    }

    @Override
    public Users create() throws DAOException {
        Users user = new Users();
        return create(user);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT* FROM users";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE users SET login = ?, password = ? WHERE user_id = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM users WHERE user_id = ?";
    }

    @Override
    public String getInsertQuery() {
        return "INSERT INTO users (login, password) VALUES (?, ?)";
    }

    @Override
    public String getWhereQuery() {
        return " WHERE user_id = ";
    }

    @Override
    public List<Users> parseResultSet(ResultSet res) throws DAOException, SQLException {
        List<Users> users = new ArrayList<>();
        try {
            while(res.next()){
                int u_id = res.getInt("user_id");
                String login = res.getString("login");
                String password = res.getString("password");
                users.add(new Users(u_id, login, password));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return users;
    }

    @Override
    public void setStatementForUpdate(Users obj, PreparedStatement statement) throws DAOException {
        try {
            statement.setString(1, obj.getLogin());
            statement.setString(2, obj.getPassword());
            statement.setInt(3, obj.getId());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void setStatementForInsert(Users obj, PreparedStatement statement) throws DAOException {
        try {
            statement.setString(1, obj.getLogin());
            statement.setString(2, obj.getPassword());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void setStatementForDelete(Users obj, PreparedStatement statement) throws DAOException {
        try {
            statement.setInt(1, obj.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
