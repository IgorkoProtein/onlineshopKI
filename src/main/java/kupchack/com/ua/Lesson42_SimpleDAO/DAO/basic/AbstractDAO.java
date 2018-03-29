package kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

public abstract class AbstractDAO<T extends Identificator<P>, P extends Integer> implements GenericDAO<T, P> {
    private static final Logger log = Logger.getLogger(AbstractDAO.class);
    private Connection connection;


    public abstract String getSelectQuery();
    public abstract String getUpdateQuery();
    public abstract String getDeleteQuery();
    public abstract String getInsertQuery();
    public abstract String getWhereQuery();

    public abstract List<T> parseResultSet(ResultSet res) throws DAOException, SQLException;
    public abstract void setStatementForUpdate(T obj, PreparedStatement statement) throws DAOException;
    public abstract void setStatementForInsert(T obj, PreparedStatement statement) throws DAOException;
    public abstract void setStatementForDelete(T obj, PreparedStatement statement) throws DAOException;

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public T create(T obj) throws DAOException {
        PreparedStatement statement;
        T tempObj;
        String sql_query = getInsertQuery();

        try {
            log.info("Getting statement for INSERT query");
            statement = connection.prepareStatement(sql_query);

            setStatementForInsert(obj, statement);

            int count = statement.executeUpdate();
            if (count == 1) {
                System.out.println("obj was created");
                log.info("obj was created");
            }else throw new SQLException("Created more than one record");

        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Cannot create new obj ");
            log.error(e.getStackTrace());
        }
        sql_query = getSelectQuery() + getWhereQuery() + "(SELECT last_insert_id())";

        try {
            statement = connection.prepareStatement(sql_query);
            ResultSet rs = statement.executeQuery();
            List<T> list = parseResultSet(rs);
            if(list == null || list.size() != 1){
                throw new DAOException("Cannot wind last created record");
            }
            tempObj = list.get(0);

        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return tempObj;
    }


    @Override
    public T read(P key) throws DAOException {
        PreparedStatement statement = null;
        List<T> list = null;

        String sql_query = getSelectQuery()+getWhereQuery()+"?";

        try {
            log.info("Getting statement");
            statement = connection.prepareStatement(sql_query);
            statement.setInt(1, key);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
            if (list.size() != 1) {
                throw new SQLException("We got more than one record");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Cannot get obj");
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
                log.error("Error during connection closing in get method");
                log.error(obj.getStackTrace());
            }
        }
        return list.get(0);
    }

    @Override
    public void update(T obj) throws DAOException {
        PreparedStatement statement = null;
        String sql_query = getUpdateQuery();

        try {
            log.info("Getting connection for update query");
            log.info("Getting preparestatement for update query");
            statement = connection.prepareStatement(sql_query);

            setStatementForUpdate(obj, statement);

            int count = statement.executeUpdate();

            if (count == 1) {
                System.out.println("person was updated");
                log.info("person was updated");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Cannot update obj ");
            log.error(e.getStackTrace());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException obj1) {
                log.error("Error during connection closing in person update method");
                log.error(obj1.getStackTrace());
            }
        }
    }

    @Override
    public void delete(T obj) throws DAOException {
        PreparedStatement statement = null;

        String sql_query = getDeleteQuery();

        try {
            log.info("Getting statement for DELETE query");
            statement = connection.prepareStatement(sql_query);

            setStatementForDelete(obj, statement);

            int count = statement.executeUpdate();
            if (count == 1) {
                System.out.println("user was deleted");
                log.info("user was deleted");
            }


        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Cannot delete obj ");
            log.error(e.getStackTrace());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException obj1) {
                log.error("Error during connection closing ");
                log.error(obj1.getStackTrace());
            }
        }
    }

    @Override
    public List<T> readAll() throws DAOException {
        List<T> list;
        String query = getSelectQuery();

        PreparedStatement statement;

        try {
            statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            list = parseResultSet(rs);

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return list;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
