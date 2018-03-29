package kupchack.com.ua.Lesson42_SimpleDAO.DAO.MySQL;

import kupchack.com.ua.Lesson42_SimpleDAO.DAO.beans.MuscleGroup;
import kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic.AbstractDAO;
import kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MuscleDAO extends AbstractDAO<MuscleGroup, Integer> {

    public MuscleDAO(Connection connection) {
        super(connection);
    }

    @Override
    public MuscleGroup create() throws DAOException {
        MuscleGroup mg = new MuscleGroup();
        return create(mg);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT* FROM muscle_group ";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE muscle_group SET name =  ? WHERE muscle_id =  ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM muscle_group WHERE name LIKE ?";
    }

    @Override
    public String getInsertQuery() {
        return "INSERT INTO muscle_group (name) VALUES (?)";
    }

    @Override
    public String getWhereQuery() {
        return " WHERE muscle_id = ";
    }

    @Override
    public List<MuscleGroup> parseResultSet(ResultSet res) throws DAOException {
        List<MuscleGroup> muscles = new ArrayList<>();

        try {
            while (res.next()){
                int m_id = res.getInt("muscle_id");
                String m_name = res.getString("name");
                muscles.add(new MuscleGroup(m_id, m_name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return muscles;
    }

    @Override
    public void setStatementForUpdate(MuscleGroup obj, PreparedStatement statement) throws DAOException {
        try {
            statement.setString(1, obj.getName());
            statement.setInt(2, obj.getId());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void setStatementForInsert(MuscleGroup obj, PreparedStatement statement) throws DAOException {
        try {
            statement.setString(1, obj.getName());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void setStatementForDelete(MuscleGroup obj, PreparedStatement statement) throws DAOException {
        try {
            statement.setInt(1, obj.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
